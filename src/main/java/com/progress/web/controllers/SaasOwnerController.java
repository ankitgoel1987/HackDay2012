package com.progress.web.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import json.parse.fb.FbUserAPI;
import json.parse.fb.FbUserData;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.progress.jpa.Authorities;
import com.progress.jpa.ComposeMail;
import com.progress.jpa.Golfcourse;
import com.progress.jpa.Users;
import com.progress.services.impl.BookingServiceImpl;
import com.progress.services.impl.MailServiceImpl;
import com.progress.services.impl.WeatherServiceImpl;
import com.progress.services.interfaces.AuthorityService;
import com.progress.services.interfaces.GcRegistrationService;
import com.progress.services.interfaces.MailService;
import com.progress.services.interfaces.UserService;

/**
 * 
 * @author agoel
 * 
 */
@Controller
public class SaasOwnerController {

	@Autowired
	private BookingServiceImpl bookingServiceImpl;
	@Autowired
	private WeatherServiceImpl weatherServiceImpl;
	@Autowired
	private UserService userService;
	@Autowired
	private GcRegistrationService gcServiceImpl;
	@Autowired
	private AuthorityService authorityService;

	private Users getAuthenticatedUser(Principal temp) {
		boolean authenticated = false;
		Users user = null;
		UsernamePasswordAuthenticationToken principal = (UsernamePasswordAuthenticationToken) temp;
		if (principal != null) {
			authenticated = principal.isAuthenticated();
			if (authenticated != false) {
				user = (Users) principal.getPrincipal();
				// List<GrantedAuthority> authorities =
				// ((List<GrantedAuthority>) principal
				// .getAuthorities());
			}
		}
		return user;
	}

	@RequestMapping(value = "fbRegister", method = RequestMethod.POST)
	public String generateFbUser(HttpServletRequest req, ModelMap model,
			Principal principal) throws JsonParseException,
			JsonMappingException, IOException {

		String signature = req.getParameter("signed_request").toString();

		String data = getJSONObject(signature);
		FbUserData fbData = FbUserAPI.main(data.toString());
		Users user = new Users();

		String name = fbData.getRegistration().getName();
		String email = fbData.getRegistration().getEmail();
		String password = fbData.getRegistration().getPassword();
		String phonenumber = fbData.getRegistration().getPhone();
		ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
		password = encoder.encodePassword(password, null);

		String username = "golfclubmember";

		Golfcourse mygc = gcServiceImpl.getGolfCourseByID(1);

		Authorities authoRities = authorityService.getAuthorityByAuthorityId(1);

		user.setName(name);
		user.setUsername(email);
		user.setAuthority(authoRities);
		user.setEmail(email);
		user.setPassword(password);
		user.setGolfcourse(mygc);
		user.setEnabled("true");
		user.setPhoneNumber(phonenumber);
		userService.addLogin(user);
		ComposeMail composedMail = new ComposeMail(user.getName(), user.getEmail());
		// Call the mail service to shoot a mail
		MailService mailService = new MailServiceImpl();
		mailService.confirmRegistration(composedMail);
		return "index";
	}

	public String getJSONObject(String signedReq) throws JsonParseException,
			JsonMappingException, IOException {
		// The parameter contains encoded signature and payload separated by ‘.’
		StringTokenizer st = new StringTokenizer(signedReq, ".");
		int count = 0;
		String payload = null;

		while (st.hasMoreTokens()) {
			if (count == 1) {
				payload = st.nextToken();
				break;
			} else
				st.nextToken();
			count++;
		}
		// Initialize Base64 decoder
		Base64 base64 = new Base64(true);
		// Replace special character in payload as indicated by FB
		payload = payload.replace("-", "+").replace("_", "/").trim();
		System.out.println("The paylod " + payload);
		JSONObject data = null;
		try {
			data = new JSONObject(new String(base64.decode(payload
					.getBytes("UTF-8"))));
			System.out.println("\n\n The deocded JSON: " + data.toString());
			return data.toString();
			// String phnnumber=fbData.getRegistration().get;
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		return "";
	}

	@RequestMapping(value = "golfCourseList", method = RequestMethod.GET)
	public String showGolfCourseList(ModelMap model, Principal principal) {
		System.out.println("Golf Course LIST Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		List<Golfcourse> allGolfCourses = gcServiceImpl.getAllGolfCourses();
		System.out.println(allGolfCourses);
		model.addAttribute("allGolfCourses", allGolfCourses);
		return "golfCourseList";
	}

	@RequestMapping(value = "gcRegistration", method = RequestMethod.GET)
	public String registerGolfCourse(ModelMap model, Principal principal) {
		System.out.println("GolfCourseRegistration GET Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}

		Golfcourse gc = new Golfcourse();
		model.addAttribute("golfCourse", gc);
		return "golfcourseregistration";
	}

	@RequestMapping(value = "gcRegistration", method = RequestMethod.POST)
	public String addGolfCourse(@ModelAttribute("golfCourse") Golfcourse gc,
			ModelMap model, Principal principal) {
		System.out.println("GolfCourseRegistration POST Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		gc.setUrlExtension(gc.getName());
		gcServiceImpl.addGolfCourse(gc);
		return "index";
	}

	// @RequestMapping(value = "accountsettings", method = RequestMethod.GET)
	// public String accountSettings(ModelMap model, Principal principal) {
	// System.out.println("Account Settings Controller\n");
	// model.addAttribute("principal", principal);
	// Users user = getAuthenticatedUser(principal);
	// if (user == null) {
	// return "index";
	// }
	// model.addAttribute("user", user);
	// return "accountchange";
	// }
	//
	// @RequestMapping(value = "accountsettings", method = RequestMethod.POST)
	// public String saveAccountSettings(@ModelAttribute("user") Users user,
	// Model model, Principal principal) {
	// System.out.println("Account Settings Controller\n");
	// model.addAttribute("principal", principal);
	// // userService123.updateUser(user);
	// if (user == null) {
	// return "index";
	// }
	// model.addAttribute("user", user);
	// return "accountchange";
	// }

}