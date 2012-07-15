package com.progress.web.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import json.parse.fb.FbUserAPI;
import json.parse.fb.FbUserData;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.progress.dao.impl.AuthorityDaoImpl;
import com.progress.dao.impl.GolfCourseDaoImpl;
import com.progress.dao.impl.UserDaoImpl;
import com.progress.jpa.Authorities;
import com.progress.jpa.Golfcourse;
import com.progress.jpa.Users;
import com.progress.services.impl.GcRegistrationServiceImpl;

/**
 * 
 * @author agoel
 * 
 */
@Controller
public class WelcomeController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {
		System.out.println("Welcome Controller\n");
		model.addAttribute("principal", principal);
		return "index";

	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String showHomePage(ModelMap model, Principal principal) {
		System.out.println("Welcome Controller\n");
		model.addAttribute("principal", principal);
		return "index";

	}

	@RequestMapping(value = "location", method = RequestMethod.GET)
	public String location(ModelMap model, Principal principal) {
		System.out.println("Welcome Controller\n");
		model.addAttribute("principal", principal);
		return "location";

	}

	@RequestMapping(value = "gallery", method = RequestMethod.GET)
	public String showGallery(ModelMap model, Principal principal) {
		System.out.println("Welcome Controller\n");
		model.addAttribute("principal", principal);
		return "gallery";
	}

	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String memberWelcome(ModelMap model, Principal principal) {
		System.out.println("Member welcome Controller\n");
		model.addAttribute("principal", principal);
		return "member/memberPage1";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminWelcome(ModelMap model, Principal principal) {
		System.out.println("Admin Welcome Controller\n");
		return "admin/adminPage1";

	}

	@RequestMapping(value = "golfCourseActivity", method = RequestMethod.GET)
	public String showGolfCourseActivity(ModelMap model, Principal principal) {
		System.out.println("Admin Welcome Controller\n");
		return "golfCourseDetails";

	}

	@RequestMapping(value = "saasDetails", method = RequestMethod.GET)
	public String showSaasDetails(ModelMap model, Principal principal) {
		System.out.println("Admin Welcome saaas\n");
		return "saasDetails";

	}

	@RequestMapping(value = "golfCourseRegister", method = RequestMethod.GET)
	public String showGolfCourseRegister(ModelMap model, Principal principal) {
		System.out.println("Admin Welcome Controller\n");
		return "golfcourseregistration";

	}

	@RequestMapping(value = "myBooking", method = RequestMethod.GET)
	public String showMyBooking(ModelMap model, Principal principal) {
		System.out.println("Admin Welcome Controller\n");
		return "mybookings";
	}

	// @RequestMapping(value = "registerNewUser", method = RequestMethod.POST)
	// public String registerNewUser(HttpServletRequest request, ModelMap model,
	// Principal principal) throws JsonParseException,
	// JsonMappingException, IOException {
	// System.out.println("Decoding Signed Req Controller\n");
	// System.out.println(request.getParameter("signed_request"));
	// getJSONObject(request.getParameter("signed_request"));
	// return "home";
	// }
	//
	// @RequestMapping(value = "fbregister", method = RequestMethod.POST)
	// public void generateFbUser(HttpServletRequest req, ModelMap model,
	// Principal principal) throws JsonParseException,
	// JsonMappingException, IOException {
	//
	// String signature = req.getParameter("signed_request").toString();
	//
	// String data = getJSONObject(signature);
	// FbUserData fbData = FbUserAPI.main(data.toString());
	// Users user = new Users();
	//
	// String name = fbData.getRegistration().getName();
	// String email = fbData.getRegistration().getEmail();
	// String password = fbData.getRegistration().getPassword();
	// ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
	// password = encoder.encodePassword(password, null);
	//
	// String username = "golfclubmember";
	//
	// Golfcourse mygc = gcDaoImpl.getGolfCourseByID(1);
	//
	// AuthorityDaoImpl adl = new AuthorityDaoImpl();
	// Authorities authoRities = adl.getAuthorityByAuthorityId(1);
	//
	// user.setName(name);
	// user.setUsername(username);
	// user.setAuthority(authoRities);
	// user.setEmail(email);
	// user.setPassword(password);
	// user.setGolfcourse(mygc);
	// user.setEnabled("true");
	//
	// UserDaoImpl userDaoImpl = new UserDaoImpl();
	// userDaoImpl.addLogin(user);
	// }
	//
	// public String getJSONObject(String signedReq) throws JsonParseException,
	// JsonMappingException, IOException {
	// // The parameter contains encoded signature and payload separated by ‘.’
	// StringTokenizer st = new StringTokenizer(signedReq, ".");
	// int count = 0;
	// String payload = null;
	//
	// while (st.hasMoreTokens()) {
	// if (count == 1) {
	// payload = st.nextToken();
	// break;
	// } else
	// st.nextToken();
	// count++;
	// }
	// // Initialize Base64 decoder
	// Base64 base64 = new Base64(true);
	// // Replace special character in payload as indicated by FB
	// payload = payload.replace("-", "+").replace("_", "/").trim();
	// System.out.println("The paylod " + payload);
	// JSONObject data = null;
	// try {
	// data = new JSONObject(new String(base64.decode(payload
	// .getBytes("UTF-8"))));
	// System.out.println("\n\n The deocded JSON: " + data.toString());
	// return data.toString();
	// // String phnnumber=fbData.getRegistration().get;
	// } catch (UnsupportedEncodingException e1) {
	// e1.printStackTrace();
	// } catch (JSONException e1) {
	// e1.printStackTrace();
	// }
	// return "";
	// }
}