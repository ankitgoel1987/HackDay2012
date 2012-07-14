package json.parse.hourlydata;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;

class HourComparator implements Comparator<MyHourlyData> {
	@Override
	public int compare(MyHourlyData o1, MyHourlyData o2) {
		return o1.getDate().getHours() - o2.getDate().getHours();
	}
}

public class WeatherAPI {
	// TODO : this will be populated by the user
	static String KEY = "4ee6ef6d03449bcf";
	static String FEATURE = "hourly10day";// can have more than 1 feature
	static String SETTING = "lang";// optional
	static String FORMAT = "json";// optional
	static String QUERY = "India/Hyderabad";

	static String URL_STRING = "http://api.wunderground.com/api/" + KEY + "/"
			+ FEATURE + "/q/" + QUERY + "." + FORMAT;
	static ArrayList<MyHourlyData> alist = new ArrayList<MyHourlyData>();
	static TreeMap<Long, MyHourlyData> epochmap = new TreeMap<Long, MyHourlyData>();
	static TreeMap<String, ArrayList<MyHourlyData>> datemap = new TreeMap<String, ArrayList<MyHourlyData>>();

	public static ArrayList<MyHourlyData> get12HourList(String dd, String mm,
			String yyyy) throws Exception {
		initialize();
		System.out.println("DATE MAP:");
		//System.out.println(datemap);
		ArrayList<MyHourlyData> alist = datemap.get(dd + "-" + mm + "-" + yyyy);
		return datemap.get(dd + "-" + mm + "-" + yyyy);
	}

	public static void initialize() throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(URL_STRING);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		InputStream is = entity.getContent();

		final char[] buffer = new char[0x10000];
		StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(is, "UTF-8");
		try {
			int read;
			do {
				read = in.read(buffer, 0, buffer.length);
				if (read > 0) {
					out.append(buffer, 0, read);
				}
			} while (read >= 0);
		} finally {
			in.close();
		}

		String result = out.toString();
		String s1 = result.replaceAll("FCTTIME", "fcttime");
		System.out.println(s1);
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		WeatherHourlyData weather = mapper.readValue(s1,
				WeatherHourlyData.class);
		int pos = 0;

		for (int i = 0; i < 10; i = i + 1) {
			ArrayList<MyHourlyData> daywiseList = new ArrayList<MyHourlyData>();
			Date d = null;
			for (int j = 0; j < 24; j++) {
				Hourly_forecast forecast = weather.getHourly_forecast()[pos++];
				Temperature t = new Temperature();
				t.setValue(forecast.getTemp().getEnglish());
				t.setUnit("F");
				
				d = new Date(new Integer(forecast.getFcttime().getYear()),
						new Integer(forecast.getFcttime().getMon()),
						new Integer(forecast.getFcttime().getMday()),
						new Integer(forecast.getFcttime().getHour()),
						new Integer(forecast.getFcttime().getMin()));
				if (d.getHours() >= 6 && d.getHours() < 19) {
					MyHourlyData myforecast = new MyHourlyData();
					myforecast.setTemp(t);
					myforecast.setCondition(forecast.getCondition());
					myforecast.setDate(d);
					myforecast.setHumidity(forecast.getHumidity());
					myforecast.setIconUrl(forecast.getIcon_url());
					alist.add(myforecast);
					epochmap.put(d.getTime(), myforecast);
					daywiseList.add(myforecast);
				}
			}
			HourComparator hc = new HourComparator();
			Collections.sort(daywiseList, hc);
			datemap.put(d.getDate() + "-" + d.getMonth() + "-" + d.getYear(),daywiseList);
		}
	}
	
	public static void main(String[] args) throws Exception {
		WeatherAPI.get12HourList("15", "7", "2012");
	}
}
