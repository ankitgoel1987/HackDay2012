package com.progress.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.util.Calendar;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.Organizer;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.util.UidGenerator;

import com.progress.services.interfaces.CalendarService;

public class CalendarServiceImpl implements CalendarService {

	@Override
	public File createMeetingFile(Calendar startDate, int duration) {
		try {
			java.util.TimeZone calTimeZone = startDate.getTimeZone();
			logMessage(calTimeZone.toString());

			// Create a TimeZone
			TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
			TimeZone timezone = registry.getTimeZone(calTimeZone.getID());
			VTimeZone tz = timezone.getVTimeZone();

			// End Date is on: April 1, 2008, 13:00
			java.util.Calendar endDate = java.util.Calendar.getInstance(calTimeZone);
			endDate.set(java.util.Calendar.MONTH, startDate.MONTH);
			endDate.set(java.util.Calendar.DAY_OF_MONTH, startDate.DAY_OF_MONTH);
			endDate.set(java.util.Calendar.YEAR, startDate.DAY_OF_YEAR);
			endDate.set(java.util.Calendar.HOUR_OF_DAY, startDate.HOUR_OF_DAY);
			endDate.set(java.util.Calendar.MINUTE, startDate.HOUR_OF_DAY + duration);
			endDate.set(java.util.Calendar.SECOND, 0);

			// Create the event
			String eventName = "GolfCourse Tee Booking Details";
			DateTime start = new DateTime(startDate.getTime());
			DateTime end = new DateTime(endDate.getTime());
			VEvent meeting = new VEvent(start, end, eventName);

			// add timezone info..
			meeting.getProperties().add(tz.getTimeZoneId());

			Uid uid = new Uid("5634923479873492613482374234");// dummy default
			// generate unique identifier..
			try {
				UidGenerator ug = new UidGenerator("uidGen");
				uid = ug.generateUid();

				// Add organizer
				Organizer organizer = new Organizer("mailto:golfcourseteam@cloudfoundry.com");
				meeting.getProperties().add(organizer);
			} catch (SocketException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			meeting.getProperties().add(uid);

			// Create a calendar
			net.fortuna.ical4j.model.Calendar icsCalendar = new net.fortuna.ical4j.model.Calendar();
			icsCalendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));

			// Add the event and print
			icsCalendar.getComponents().add(meeting);
			logMessage("ICS formed successfully "+icsCalendar);

			try {
				File f = File.createTempFile("Invite", "Req");
				logMessage("About to write ICS file at " + f.getAbsolutePath());
				// filePathToWrite = "." + File.separator + "invites" +
				// File.separator + f.getName() + ".ics";

				FileOutputStream fout = new FileOutputStream(f);
				CalendarOutputter outputter = new CalendarOutputter();
				outputter.setValidating(false);
				outputter.output(icsCalendar, fout);
				return f;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ValidationException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return new File();//fall back if there is any issues, send default
		// ics file
		return null;
	}
	
	public void logMessage(String msg) {
		System.out.println("[CALENDAR-SERVICE] " + msg);
	}
}
