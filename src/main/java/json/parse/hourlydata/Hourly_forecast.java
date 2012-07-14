package json.parse.hourlydata;


//@JsonIgnoreProperties({"FCTTIME"})
public class Hourly_forecast {
	
	private fcttime _fcttime;
	private Temp _temp;
	private Dewpoint _dewpoint;
	private String _condition;
	private String _icon;
	private String _icon_url;
	private String  _fctcode;
	private String _sky;
	private Wspd _wspd;
	private Wdir _wdir;
	private String _wx;
	private String _uvi;
	private String _humidity;
	private Windchill _windchill;
	private Heatindex _heatindex;
	private Feelslike _feelslike;
	private Qpf _qpf;
	private Snow _snow;
	private String _pop;
	private Mslp _mslp;
	
	
	public fcttime getFcttime() {
		return _fcttime;
	}
	public void setFcttime(fcttime _fcttime) {
		this._fcttime = _fcttime;
	}
	
	
	public Mslp getMslp() {
		return _mslp;
	}
	public void setMslp(Mslp _mslp) {
		this._mslp = _mslp;
	}
	
	
	public Temp getTemp() {
		return _temp;
	}
	
	
	
	public void setTemp(Temp _temp) {
		this._temp = _temp;
	}
	public Dewpoint getDewpoint() {
		return _dewpoint;
	}
	public void setDewpoint(Dewpoint _dewpoint) {
		this._dewpoint = _dewpoint;
	}
	public String getCondition() {
		return _condition;
	}
	public void setCondition(String _condition) {
		this._condition = _condition;
	}
	public String getIcon() {
		return _icon;
	}
	public void setIcon(String _icon) {
		this._icon = _icon;
	}
	public String getIcon_url() {
		return _icon_url;
	}
	public void setIcon_url(String _icon_url) {
		this._icon_url = _icon_url;
	}
	public String getFctcode() {
		return _fctcode;
	}
	public void setFctcode(String _fctcode) {
		this._fctcode = _fctcode;
	}
	public String getSky() {
		return _sky;
	}
	public void setSky(String _sky) {
		this._sky = _sky;
	}
	public Wspd getWspd() {
		return _wspd;
	}
	public void setWspd(Wspd _wspd) {
		this._wspd = _wspd;
	}
	public Wdir getWdir() {
		return _wdir;
	}
	public void setWdir(Wdir _wdir) {
		this._wdir = _wdir;
	}
	public String getWx() {
		return _wx;
	}
	public void setWx(String _wx) {
		this._wx = _wx;
	}
	public String getUvi() {
		return _uvi;
	}
	public void setUvi(String _uvi) {
		this._uvi = _uvi;
	}
	public String getHumidity() {
		return _humidity;
	}
	public void setHumidity(String _humidity) {
		this._humidity = _humidity;
	}
	public Windchill getWindchill() {
		return _windchill;
	}
	public void setWindchill(Windchill _windchill) {
		this._windchill = _windchill;
	}
	public Heatindex getHeatindex() {
		return _heatindex;
	}
	public void setHeatindex(Heatindex _heatindex) {
		this._heatindex = _heatindex;
	}
	public Feelslike getFeelslike() {
		return _feelslike;
	}
	public void setFeelslike(Feelslike _feelslike) {
		this._feelslike = _feelslike;
	}
	public Qpf getQpf() {
		return _qpf;
	}
	public void setQpf(Qpf _qpf) {
		this._qpf = _qpf;
	}
	public Snow getSnow() {
		return _snow;
	}
	public void setSnow(Snow _snow) {
		this._snow = _snow;
	}
	public String getPop() {
		return _pop;
	}
	public void setPop(String _pop) {
		this._pop = _pop;
	}
	
}
