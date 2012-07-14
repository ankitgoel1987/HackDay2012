package json.parse.dailydata;

public class Txt_forecast {
	private String _date;
	private Forecastday _forecastday[];
	public String getDate() {
		return _date;
	}
	public void setDate(String _date) {
		this._date = _date;
	}
	public Forecastday[] getForecastday() {
		return _forecastday;
	}
	public void setForecastday(Forecastday[] _forecastday) {
		this._forecastday = _forecastday;
	}
}
