package com.progress.services.interfaces;

import java.io.File;
import java.util.Calendar;

public interface CalendarService {

	public File createMeetingFile(Calendar bookingDate, int duration);
}
