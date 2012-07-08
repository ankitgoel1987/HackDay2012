package com.progress.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.progress.jpa.FacebookAuthTokenHolder;

/**
 * Handles Interaction with Facebook
 * 
 * @author kiranb
 * 
 */
@Controller
public class FacebookController {

	// Hyper link action...
	@RequestMapping(value = "fbAuth", method = RequestMethod.GET)
	public String showFacebookAuthDialog(Model model) {
		System.out.println("Received request to authenticate in facebook");
		/*
		 * http://www.facebook.com/dialog/oauth/? client_id=YOUR_APP_ID
		 * &redirect_uri=YOUR_REDIRECT_URL &state=YOUR_STATE_VALUE
		 * &scope=COMMA_SEPARATED_LIST_OF_PERMISSION_NAMES
		 */
		StringBuilder fbUrlBuilder = new StringBuilder("redirect:https://graph.facebook.com/oauth/authorize?");
		fbUrlBuilder.append("type=user_agent");
		fbUrlBuilder.append("&client_id=384457681620517");
		// TBD Temporarily hooking in mail form...
		fbUrlBuilder.append("&redirect_uri=http://progress.cloudfoundry.com/showAuthResult");
		fbUrlBuilder.append("&state=getAuthToken");
		// fbUrlBuilder.append("&scope=read_stream");
		fbUrlBuilder.append("&response_type=token");

		System.out.println("The FB Auth URL " + fbUrlBuilder.toString());

		return fbUrlBuilder.toString();
	}

	@RequestMapping(value = "showAuthResult", method = RequestMethod.GET)
	public String showFacebookAuthResult(Model model) {
		model.addAttribute("authTokenHolder", new FacebookAuthTokenHolder());
		return "facebook/showAuthResult";
	}

	@RequestMapping(value = "FbPost", method = RequestMethod.POST)
	public String postAMessage(@ModelAttribute("authTokenHolder") FacebookAuthTokenHolder authHolder, Model model) {
		System.out.println("Received request in post message [AuthToken]" + authHolder.getAuthToken());
		// how to get hold of the response
		return "facebook/showAuthResult";
	}

}
