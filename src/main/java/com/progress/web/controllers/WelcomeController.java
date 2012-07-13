package com.progress.web.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		return "index";

	}

	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String memberWelcome(ModelMap model, Principal principal) {
		System.out.println("Member welcome Controller\n");
		return "member/memberPage1";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminWelcome(ModelMap model, Principal principal) {
		System.out.println("Admin Welcome Controller\n");
		return "admin/adminPage1";

	}
}