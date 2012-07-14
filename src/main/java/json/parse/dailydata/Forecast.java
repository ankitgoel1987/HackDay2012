package json.parse.dailydata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"simpleforecast"})
public class Forecast {
	private Txt_forecast _txt_forecast;

	public Txt_forecast getTxt_forecast() {
		return _txt_forecast;
	}

	public void setTxt_forecast(Txt_forecast _txt_forecast) {
		this._txt_forecast = _txt_forecast;
	}
}
