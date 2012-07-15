package com.progress.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.progress.jpa.Authorities;
import com.progress.jpa.Users;
import com.progress.services.interfaces.AuthorityService;
import com.progress.services.interfaces.UserService;

/**
 * 
 * @author agoel
 * 
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private AuthorityService authorityService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String printLogin(Model model, Principal principal) {
	//
	// System.out.println("Received request to show login page\n");
	// model.addAttribute("principal", principal);
	// return "login";
	//
	// }
	//
	// @RequestMapping(value = "/loginFail", method = RequestMethod.GET)
	// public String printLoginFail(Model model, Principal principal) {
	//
	// System.out.println("Received request to show loginFail page\n");
	// model.addAttribute("principal", principal);
	// return "loginFail";
	//
	// }

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String printAccessDenied(Model model, Principal principal) {
		System.out.println("Showing Access Denied Page\n");
		model.addAttribute("principal", principal);
		return "accessDenied";
	}

	// @RequestMapping(value = "/admin/listLogin", method = RequestMethod.GET)
	// public String listLogin(Model model, Principal principal) {
	// System.out.println("Received request to show all schools");
	//
	// // Retrieve all users by delegating the call to UserService
	// List<Users> user = this.userService.getAll();
	//
	// System.out.println("Received request carried out + " + user);
	//
	// model.addAttribute("users", user);
	// model.addAttribute("principal", principal);
	// // This will resolve to /WEB-INF/admin/lisLogin.jsp
	// return "admin/listLogin";
	// }
	//
	// /**
	// * Retrieves the add page
	// *
	// * @return the name of the JSP page
	// */
	// @RequestMapping(value = "/admin/addLogin", method = RequestMethod.GET)
	// public String getAddlogin(Model model, Principal principal) {
	//
	// System.out.println("Show Add form\n");
	// // Create new Login and add to model
	// // This is the formBackingOBject
	// List<Authorities> authorities = this.authorityService.getAll();
	// model.addAttribute("userAttribute", new Users());
	//
	// model.addAttribute("authorities", authorities);
	// model.addAttribute("principal", principal);
	// // This will resolve to /WEB-INF/jsp/admin/addLoginPage.jsp
	// return "admin/addLogin";
	// }
	//
	// @RequestMapping(value = "/admin/addLogin", method = RequestMethod.POST)
	// public String add(@ModelAttribute("userAttribute") Users user, Model
	// model, Principal principal) {
	// ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
	// user.setPassword(encoder.encodePassword(user.getPassword(), null));
	// System.out.println(user.getUsername() + " "
	// + encoder.encodePassword(user.getPassword(), null) + " "
	// + user.getEnabled() + " "
	// + user.getAuthority().getAuthority());
	// model.addAttribute("principal", principal);
	// userService.addLogin(user);
	// // This will resolve to /WEB-INF/jsp/addedSchoolPage.jsp
	// return listLogin(model, principal);
	// }
}