package json.parse.dailydata;

public class MyDailyData {
	private String hoverText;
	private String temp;
	private String humidity;
	private String iconUrl;
	private String condition;
	
	public String getHoverText() {
		return hoverText;
	}
	public void setHoverText(String hoverText) {
		this.hoverText = hoverText;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	public String getIconUrl() {
		return iconUrl;
	}
	
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
}
