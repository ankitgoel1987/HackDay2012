package json.parse.fb;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FbUserAPI {
	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		FbUserData fbUser = mapper.readValue(new File(
				"C:/Users/agupta.APAC/Desktop/pavans.json"), FbUserData.class);
		System.out.println(fbUser.getRegistration().getBirthday());
		System.out.println(fbUser.getAlgorithm());
		System.out.println(fbUser.getUser_id());
	}

	public static FbUserData main(String args) throws JsonParseException,
			JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		FbUserData fbUser = mapper.readValue(args, FbUserData.class);
		return fbUser;

	}

}