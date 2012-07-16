package com.progress.services.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.ws.rs.core.MediaType;

import org.springframework.web.client.RestTemplate;

import com.progress.jpa.BookingBean;
import com.progress.jpa.ComposeMail;
import com.progress.services.interfaces.CalendarService;
import com.progress.services.interfaces.MailService;
import com.progress.services.mail.BasicAuthBasedRestTemplate;
import com.progress.services.sms.Way2Sms;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

/**
 * Use this class to sending mails
 * 
 * @author kiranb
 * 
 */
public class MailServiceImpl implements MailService {

	private static final String MAILGUN_MAIL_SEND_REST_URI = "https://api.mailgun.net/v2/kiranb.mailgun.org/messages";
	private static final String MAILGUN_USER_NAME = "api";
	private static final String MAILGUN_PASSWORD = "key-8a66c1hew6iis15f5li-kdokywyom1u5";

	private static final String GOLF_COURSE_FROM = "golfcourseteam@cloudfoundry.com";

	@Override
	public void confirmRegistration(ComposeMail mailData) {
		logMessage("Received request to send confirmation of registration.");
		mailData.setFrom(GOLF_COURSE_FROM);
		mailData.setSubject("GolfCourse registration confirmatioin");
		String mailbody = "<p>Hi " + mailData.getUserName() + ",<br><br>Congratulations. Your registration has been successfully completed.";
		mailbody = mailbody + "<br><br>-GolfCourse Facilities Team";
		mailData.setBody(mailbody);
		// Deliver Mail
		RestTemplate rest = new BasicAuthBasedRestTemplate(MAILGUN_USER_NAME, MAILGUN_PASSWORD);
		rest.postForLocation(MAILGUN_MAIL_SEND_REST_URI, mailData.getAsValueMap());

		logMessage("Confirmation of registration mail sent successfully...");

		try {
			Way2Sms smsSender = new Way2Sms();
			smsSender.sendMessageEntryCall(mailData.getMobileNo(), mailbody);
			logMessage("Sent SMS also.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void confirmBooking(BookingBean bookingData) {
		logMessage("Received request to send confirmation of booking.");
		CalendarService calService = new CalendarServiceImpl();
		File icsFile = calService.createMeetingFile(bookingData.getBookingStartDate(), bookingData.getDuration());
		logMessage("ICS File created at " + icsFile.getAbsolutePath());
		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("api", MAILGUN_PASSWORD));
		WebResource webResource = client.resource("https://api.mailgun.net/v2/kiranb.mailgun.org/" + "messages");
		FormDataMultiPart form = new FormDataMultiPart();
		form.field("from", "Golf Course Team <" + GOLF_COURSE_FROM + ">");
		form.field("to", bookingData.getToemailAdd());
		form.field("subject", "Golf Course Tee Booking Confirmation");
		String mailBody = "<p>Hi " + bookingData.getUserName() + ",<br><br>Congratulations. Your booking has been confirmed.&nbsp;Please revert with <b>Confirmation ID:"
				+ bookingData.getConfirmID() + "</b> for future queries.</b><br><br>-GolfCourse Facilities Team</p>";
		form.field("html", mailBody);
		form.bodyPart(new FileDataBodyPart("attachment", icsFile, new MediaType("text", "calendar")));
		ClientResponse postResp = webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, form);
		logMessage("Sending Calendar Event - Status Code " + postResp.getStatus());
		
		try {
			Way2Sms smsSender = new Way2Sms();
			smsSender.sendMessageEntryCall(bookingData.getMobileNo(), mailBody);
			logMessage("Sent SMS also.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scheduleReminderMail(BookingBean bookingData) {
		Calendar dayBefore = (Calendar) bookingData.getBookingStartDate().clone();
		// dayBefore.add(Calendar.MINUTE, -1);
		dayBefore.add(Calendar.HOUR, -1);

		SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
		String format = formatter.format(dayBefore.getTime());
		logMessage("Tee Booked on " + formatter.format(bookingData.getBookingStartDate().getTime()));
		logMessage("Schedule reminder main on " + format);

		Client client = Client.create();
		client.addFilter(new HTTPBasicAuthFilter("api", MAILGUN_PASSWORD));
		WebResource webResource = client.resource("https://api.mailgun.net/v2/kiranb.mailgun.org/" + "messages");
		FormDataMultiPart form = new FormDataMultiPart();
		form.field("from", "Golf Course Team <" + GOLF_COURSE_FROM + ">");
		form.field("to", bookingData.getToemailAdd());
		form.field("subject", "Golf Course Tee Booking Reminder");
		form.field("o:deliverytime", format);
		String mailBody = "<p>Hi " + bookingData.getUserName() + ",<br><br>This is a reminder mail regarding your tee booking bearing <b>Confirmation ID:" + bookingData.getConfirmID()
				+ "</b>.<br><br>We hope you would have a great time at our Golf Course.<br><br>-GolfCourse Facilities Team</p>";
		form.field("html", mailBody);
		ClientResponse postResp = webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class, form);
		logMessage("Sent Reminder Mail - Status Code " + postResp.getStatus());
		
		try {
			Way2Sms smsSender = new Way2Sms();
			smsSender.sendMessageEntryCall(bookingData.getMobileNo(), mailBody);
			logMessage("Sent SMS also.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logMessage(String msg) {
		System.out.println("[MAIL-SERVICE] " + msg);
	}

	public static void main(String[] args) {
		MailService mailService = new MailServiceImpl();
		Calendar instance = java.util.Calendar.getInstance(new Locale(System.getProperty("user.language")));
		instance.add(Calendar.MINUTE, 3);
		System.out.println("add 12 " + instance.getTime());
		BookingBean bookingData = new BookingBean(instance, "Neela Kiran Babu", "kiranbabu.neela@gmail.com@progress.com", "9866354436", "1213213213");
		// mailService.confirmBooking(bookingData);
		mailService.scheduleReminderMail(bookingData);
	}
}
