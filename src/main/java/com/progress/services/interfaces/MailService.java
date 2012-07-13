package com.progress.services.interfaces;

import com.progress.jpa.BookingBean;
import com.progress.jpa.ComposeMail;

public interface MailService {

	public void confirmRegistration(ComposeMail mail);

	public void confirmBooking(BookingBean bookingData);

	public void scheduleReminderMail(BookingBean bean);
}
