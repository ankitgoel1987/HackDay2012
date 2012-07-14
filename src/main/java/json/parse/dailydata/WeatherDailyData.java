package json.parse.dailydata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"response"})
public class WeatherDailyData {
	private Forecast _forecast;

	public Forecast getForecast() {
		return _forecast;
	}

	public void setForecast(Forecast _forecast) {
		this._forecast = _forecast;
	}
}
