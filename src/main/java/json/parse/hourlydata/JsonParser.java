package json.parse.hourlydata;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.progress.jpa.HourlyData;


public class JsonParser {
	/*public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		// User user = mapper.readValue(new
		// File("C:/Users/agupta.APAC/Desktop/Oauth/OAuthProject1/src/json/parse/input.json"),
		// User.class);
		// System.out.println(user.getGender());W

		// Weather weather = mapper.readValue(new
		// File("C:/Users/agupta.APAC/Desktop/out_main.txt"), Weather.class);
		WeatherHourlyData weather = mapper.readValue(args[0], WeatherHourlyData.class);
		ArrayList<MyHourlyData> alist = new ArrayList<MyHourlyData>();
		for (int i = 0; i < weather.getHourly_forecast().length; i++) {
			Hourly_forecast forecast = weather.getHourly_forecast()[i];
			MyHourlyData myforecast = new MyHourlyData();
			myforecast.setHumidity(forecast.getHumidity());
			myforecast.setIconUrl(forecast.getIcon_url());
			myforecast.setTemperature(forecast.getTemp().getEnglish());
			myforecast.setCondition(forecast.getCondition());
			System.out.println(forecast.getFcttime().getYear());
			myforecast.setDateTime(new Date(new Integer(forecast.getFcttime()
					.getYear()), new Integer(forecast.getFcttime().getMon()),
					new Integer(forecast.getFcttime().getMday()), new Integer(
							forecast.getFcttime().getHour()), new Integer(
							forecast.getFcttime().getMin())));
			alist.add(myforecast);
		}
		// Humidity
		// Icon_Url
		// Temp ----> Value , Unit
		// Date ----> Day , Hour
		// Condition
		System.out.println(alist);
	}
*/
	public  void parseFeed(String args) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		WeatherHourlyData weather = mapper.readValue(args, WeatherHourlyData.class);
		ArrayList<HourlyData> alist = new ArrayList<HourlyData>();
		for (int i = 0; i < weather.getHourly_forecast().length; i++) {
			Hourly_forecast forecast = weather.getHourly_forecast()[i];
			HourlyData myforecast = new HourlyData();
			myforecast.setHumidity(forecast.getHumidity());
			myforecast.setIconUrl(forecast.getIcon_url());
			myforecast.setTemperature(forecast.getTemp().getEnglish());
			myforecast.setCondition(forecast.getCondition());
			System.out.println(forecast.getFcttime().getYear());
			alist.add(myforecast);
		}
		// Humidity
		// Icon_Url
		// Temp ----> Value , Unit
		// Date ----> Day , Hour
		// Condition
		System.out.println(alist);
	}

}
