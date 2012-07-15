package com.progress.web.controllers;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.progress.jpa.HourlyData;
import com.progress.jpa.ReservationDetailsList;
import com.progress.jpa.Reservationdetails;
import com.progress.jpa.SearchBookings;
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
public class GolfCourseMemberController {

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

	@RequestMapping(value = "myBookings", method = RequestMethod.GET)
	public String showMyBookings(ModelMap model, Principal principal) {
		System.out.println("GolfCourseMember Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		SearchBookings searchBookings = new SearchBookings();
		List<Reservationdetails> reservationdetails = bookingServiceImpl
				.getReservationDetailsByUserID(user.getUserId());
		ReservationDetailsList reservationdetailsList = new ReservationDetailsList();
		reservationdetailsList.setReservationdetails(reservationdetails);
		model.addAttribute("principal", principal);
		model.addAttribute("reservationdetailsList", reservationdetailsList);
		model.addAttribute("searchBookings", searchBookings);
		return "mybookings";
	}

	@RequestMapping(value = "myBookings", method = RequestMethod.POST)
	public String cancelMyBookings(ModelMap model, Principal principal) {
		System.out.println("GolfCourseMember Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		return "mybookings";
	}

	@RequestMapping(value = "accountsettings", method = RequestMethod.GET)
	public String accountSettings(ModelMap model, Principal principal) {
		System.out.println("Account Settings Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		Users temp = userService.getUserByUserName(user.getUsername());
		model.addAttribute("user", temp);
		return "accountchange";
	}

	@RequestMapping(value = "accountsettings", method = RequestMethod.POST)
	public String saveAccountSettings(@ModelAttribute("user") Users user,
			Model model, Principal principal) {
		System.out.println("Account Settings Controller\n");
		model.addAttribute("principal", principal);
		Users authUser = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		Users temp = userService.getUserByUserName(authUser.getUsername());
		temp.setEmail(user.getEmail());
		temp.setPhoneNumber(user.getPhoneNumber());
		temp.setName(user.getName());
		userService.updateUser(temp);
		return "accountchange";
	}

	@RequestMapping(value = "bookteetime", method = RequestMethod.GET)
	public String bookTeeTime(ModelMap model, Principal principal) {
		System.out.println("Book tee Time Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		Calendar now = Calendar.getInstance();
		int currmonth = now.get(Calendar.MONTH) + 1;
		int currday = now.get(Calendar.DATE);
		int curryear = now.get(Calendar.YEAR);
		List<HourlyData> hourlyDataList = weatherServiceImpl
				.getHourlyData(new Date(curryear, currmonth, currday));
		model.addAttribute("hourlyDataList", hourlyDataList);
		return "index";
	}
}