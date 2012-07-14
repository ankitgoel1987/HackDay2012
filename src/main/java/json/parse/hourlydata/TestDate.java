package json.parse.hourlydata;

import java.util.Calendar;

public class TestDate {
	public static void main(String[] args) {

		// create Calendar instance
		Calendar now = Calendar.getInstance();

		System.out.println("Current date : " + (now.get(Calendar.MONTH) + 1)
				+ "-" + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR));

		// add days to current date using Calendar.add method
		now.add(Calendar.DATE, 1);

		System.out.println("date after one day : "
				+ (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE)
				+ "-" + now.get(Calendar.YEAR));

		now.add(Calendar.DATE, 1);

		System.out.println("date after one day : "
				+ (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE)
				+ "-" + now.get(Calendar.YEAR));
	}

}
