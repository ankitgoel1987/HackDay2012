package com.progress.web.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;

import com.progress.jpa.Users;
import com.progress.services.impl.BookingServiceImpl;
import com.progress.services.impl.WeatherServiceImpl;
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