package com.progress.web.controllers;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.progress.jpa.BookingBean;
import com.progress.jpa.ComposeMail;
import com.progress.services.impl.MailServiceImpl;
import com.progress.services.interfaces.MailService;
import com.progress.services.mail.BasicAuthBasedRestTemplate;

/**
 * Handles Sending of the mails using the MailGun REST API...
 * 
 * @author kiranb
 * 
 */
@Controller
public class MailController {

	private static final String MAILGUN_MAIL_SEND_REST_URI = "https://api.mailgun.net/v2/kiranb.mailgun.org/messages";
	private static final String MAILGUN_USER_NAME = "api";
	private static final String MAILGUN_PASSWORD = "key-8a66c1hew6iis15f5li-kdokywyom1u5";

	// Hyper link action...
	@RequestMapping(value = "mailForm", method = RequestMethod.GET)
	public String showMailForm(Model model) {
		System.out.println("Received request to show mail form");
		ComposeMail mailData = new ComposeMail();
		model.addAttribute(ComposeMail.COMPOSE_MAIL_DATA_KEY, mailData);
		return "mail/mailform";
	}

	@RequestMapping(value = "mailForm", method = RequestMethod.POST)
	public String sendMail(@ModelAttribute("mailDataKey") ComposeMail mailData, Model model) {
		System.out.println("Received request to send mail");
		if (mailData == null) {
			System.err.println("mailDataKey: Not populated in the map, bound the with class ComposeMail");
			return "";
		}
		RestTemplate rest = new BasicAuthBasedRestTemplate(MAILGUN_USER_NAME, MAILGUN_PASSWORD);
		rest.postForLocation(MAILGUN_MAIL_SEND_REST_URI, mailData.getAsValueMap());
		System.out.println("done mail successfully...");
		return "mail/success";
	}

	/**
	 * This is a dummy call to actually call the service method
	 * 
	 * @return
	 */
	@RequestMapping(value = "confirmReg", method = RequestMethod.GET)
	public String confirmRegistration() {
		System.out.println("Dummy Confirm Registration...");
		// Create a dummy ComposeMail POJO
		ComposeMail composedMail = new ComposeMail("Kiran", "kiranbabu.neela@gmail.com");
		// Call the mail service to shoot a mail
		MailService mailService = new MailServiceImpl();
		mailService.confirmRegistration(composedMail);
		return "home";
	}

	/**
	 * This is a dummy call to actually call the service method
	 * 
	 * @return
	 */
	@RequestMapping(value = "confirmBooking", method = RequestMethod.GET)
	public String confirmBooking(){
		System.out.println("Dummy Confirm Booking...");
		// Create a dummy BookingBean POJO
		Calendar instance = java.util.Calendar.getInstance(new Locale(System.getProperty("user.language")));
		BookingBean bookingData = new BookingBean(instance, "Kiran", "kiranbabu.neela@gmail.com", "34557652535645");
		// Call the mail service to shoot a mail
		MailService mailService = new MailServiceImpl();
		mailService.confirmBooking(bookingData);
		return "home";
	}
	
	/**
	 * This is a dummy call to actually call the service method
	 * 
	 * @return
	 */
	@RequestMapping(value = "sendReminder", method = RequestMethod.GET)
	public String sendReminder(){
		System.out.println("Dummy Send Reminder...");
		// Create a dummy BookingBean POJO
		Calendar instance = java.util.Calendar.getInstance(new Locale(System.getProperty("user.language")));
		BookingBean bookingData = new BookingBean(instance, "Kiran", "kiranbabu.neela@gmail.com", "34557652535645");
		// Call the mail service to shoot a mail
		MailService mailService = new MailServiceImpl();
		mailService.scheduleReminderMail(bookingData);
		return "home";
	}

}
