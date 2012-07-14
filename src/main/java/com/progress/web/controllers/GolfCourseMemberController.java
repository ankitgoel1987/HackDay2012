package com.progress.web.controllers;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.progress.jpa.HourlyData;
import com.progress.jpa.ReservationDetailsList;
import com.progress.jpa.Reservationdetails;
import com.progress.jpa.SearchBookings;
import com.progress.jpa.Users;
import com.progress.services.impl.BookingServiceImpl;
import com.progress.services.impl.WeatherServiceImpl;

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

	// @RequestMapping(value = "newBooking", method = RequestMethod.GET)
	// public String showTeeTime(ModelMap model, Principal principal) {
	// System.out.println("GolfCourseMember Controller\n");
	// model.addAttribute("principal", principal);
	// return "booking";
	// }
	//
	// @RequestMapping(value = "newBooking", method = RequestMethod.POST)
	// public String bookTeeTime(ModelMap model, Principal principal) {
	// System.out.println("GolfCourseMember Controller\n");
	// model.addAttribute("principal", principal);
	// return "booking";
	// }

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
		return "mybookings";
	}

	@RequestMapping(value = "accountsettings", method = RequestMethod.GET)
	public String accountSettings(ModelMap model, Principal principal) {
		System.out.println("Account Settings Controller\n");
		model.addAttribute("principal", principal);
		return "accountchange";
	}

	@RequestMapping(value = "bookteetime", method = RequestMethod.GET)
	public String bookTeeTime(ModelMap model, Principal principal) {
		System.out.println("Book tee Time Controller\n");
		// create Calendar instance
				Calendar now = Calendar.getInstance();
				int currmonth = now.get(Calendar.MONTH) + 1;
				int currday = now.get(Calendar.DATE);
				int curryear = now.get(Calendar.YEAR);
		List<HourlyData> hourlyDataList = weatherServiceImpl.getHourlyData(new Date(curryear, currmonth, currday));
		model.addAttribute("principal", principal);
		model.addAttribute("hourlyDataList", hourlyDataList);
		boolean authenticated = false;
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
		if (token != null) {
			authenticated = token.isAuthenticated();
		}
		if(authenticated)
			return "booking";
		else
			return "index";
	}
}