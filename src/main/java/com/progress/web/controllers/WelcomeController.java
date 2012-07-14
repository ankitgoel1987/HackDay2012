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
}