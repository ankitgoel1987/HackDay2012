package json.parse.fb;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"issued_at","expires","registration_metadata","oauth_token"})
public class FbUserData {
	private String _user_id;
	private Registration _registration;
	private User _user;
	private String _algorithm;
	
	public String getUser_id() {
		return _user_id;
	}
	public void setUser_id(String _user_id) {
		this._user_id = _user_id;
	}
	public Registration getRegistration() {
		return _registration;
	}
	public void setRegistration(Registration _registration) {
		this._registration = _registration;
	}
	public User getUser() {
		return _user;
	}
	public void setUser(User _user) {
		this._user = _user;
	}
	public String getAlgorithm() {
		return _algorithm;
	}
	public void setAlgorithm(String _algorithm) {
		this._algorithm = _algorithm;
	}
}
