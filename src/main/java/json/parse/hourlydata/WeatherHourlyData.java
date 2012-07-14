/*
{
	"response": {
		"version": "0.1"
		,"termsofService": "http://www.wunderground.com/weather/api/d/terms.html"
		,"features": {
		"hourly10day": 1
		}
	}
}
*/
package json.parse.hourlydata;

public class WeatherHourlyData {
	private Response _response; 
	private Hourly_forecast _hourly_forecast[];
	
	public Response getResponse() {
		return _response;
	}
	
	public void setResponse(Response _response) {
		this._response = _response;
	}
	
	public Hourly_forecast[] getHourly_forecast() {
		return _hourly_forecast;
	}
	
	public void setHourly_forecast(Hourly_forecast[] _hourly_forecast) {
		this._hourly_forecast = _hourly_forecast;
	}
}
