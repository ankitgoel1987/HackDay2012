package json.parse.dailydata;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
	static String KEY = "4ee6ef6d03449bcf";
	static String FEATURE = "forecast10day";// can have more than 1 feature
	static String SETTING = "lang";// optional
	static String FORMAT = "json";// optional
	static String QUERY = "Australia/Sydney";

	static String URL_STRING = "http://api.wunderground.com/api/" + KEY + "/"
			+ FEATURE + "/q/" + QUERY + "." + FORMAT;

	static public MyDailyData benaData(int i, Forecastday[] arr) {
		Forecastday bean = arr[i];
		MyDailyData data = new MyDailyData();
		data.setIconUrl(bean.getIcon_url());
		data.setHoverText(bean.getFcttext());
		data.setHumidity(bean.getPop());
		return data;
	}

	public static void main(String[] args) throws Exception {
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
		
		String result=out.toString();
				
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		WeatherDailyData weather = mapper.readValue(result,WeatherDailyData.class);
		Forecastday[] arr = weather.getForecast().getTxt_forecast()
				.getForecastday();
		ArrayList<MyDailyData> alist = new ArrayList<MyDailyData>();
		for (int i = 0; i < arr.length; i = i + 2) {
			MyDailyData data1 = benaData(i, arr);
			int index1 = data1.getHoverText().indexOf("F.");
			String temp1 = data1.getHoverText().substring(index1 - 3,index1);
			data1.setTemp(temp1 + "");
			alist.add(data1);
		}
		
		for(int i=0;i<alist.size();i++)
			System.out.println(alist.get(i).getTemp()+"  "+i);
	}
}