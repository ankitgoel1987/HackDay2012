package com.progress.web.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.progress.jpa.Golfcourse;
import com.progress.jpa.Users;
import com.progress.services.impl.BookingServiceImpl;
import com.progress.services.impl.WeatherServiceImpl;
import com.progress.services.interfaces.GcRegistrationService;
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
	
	@RequestMapping(value = "golfCourseList", method = RequestMethod.GET)
	public String showGolfCourseList(ModelMap model, Principal principal) {
		System.out.println("Account Settings Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		model.addAttribute("user", user);
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
	public String addGolfCourse(@ModelAttribute("golfCourse") Golfcourse gc,ModelMap model, Principal principal) {
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