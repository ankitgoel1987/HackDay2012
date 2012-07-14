package json.parse.hourlydata;

public  class Response {
	private String _version, _termsofService;
	private Features _features;
	
	public Features getFeatures() {
		return _features;
	}

	public void setFeatures(Features _features) {
		this._features = _features;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String _version) {
		this._version = _version;
	}

	public String getTermsofService() {
		return _termsofService;
	}

	public void setTermsofService(String _termsofService) {
		this._termsofService = _termsofService;
	}


}

