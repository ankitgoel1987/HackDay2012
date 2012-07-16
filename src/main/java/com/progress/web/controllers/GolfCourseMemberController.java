package com.progress.web.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.progress.dao.impl.AuthorityDaoImpl;
import com.progress.dao.impl.UserDaoImpl;
import com.progress.jpa.Authorities;
import com.progress.jpa.Capacity;
import com.progress.jpa.Golfcourse;
import com.progress.jpa.HourlyData;
import com.progress.jpa.ReservationDetailsList;
import com.progress.jpa.Reservationdetails;
import com.progress.jpa.SearchBookings;
import com.progress.jpa.Users;
import com.progress.services.impl.BookingServiceImpl;
import com.progress.services.impl.WeatherServiceImpl;
import com.progress.services.interfaces.CapacityService;
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
	@Autowired
	private CapacityService capacityServiceImpl;

	private Users getAuthenticatedUser(Principal temp) {
		boolean authenticated = false;
		Users user = null;
		UsernamePasswordAuthenticationToken principal = (UsernamePasswordAuthenticationToken) temp;
		if (principal != null) {
			authenticated = principal.isAuthenticated();
			if (authenticated != false) {
				user = (Users) principal.getPrincipal();
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
		reservationdetailsList.setReservationDetails(reservationdetails);
		model.addAttribute("principal", principal);
		model.addAttribute("reservationdetailsList", reservationdetailsList);
		model.addAttribute("searchBookings", searchBookings);
		return "mybookings";
	}

	@RequestMapping(value = "cancelMyBooking", method = RequestMethod.POST)
	public String cancelMyBookings(HttpServletRequest request, ModelMap model,
			Principal principal) {
		System.out.println("GolfCourseMember Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		Enumeration params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String confirmationID = (String) params.nextElement();
			int temp = Integer.parseInt(confirmationID);
			bookingServiceImpl.cancelReservation(temp);

		}
		SearchBookings searchBookings = new SearchBookings();
		List<Reservationdetails> reservationdetails = bookingServiceImpl
				.getReservationDetailsByUserID(user.getUserId());
		ReservationDetailsList reservationdetailsList = new ReservationDetailsList();
		reservationdetailsList.setReservationDetails(reservationdetails);
		model.addAttribute("principal", principal);
		model.addAttribute("reservationdetailsList", reservationdetailsList);
		model.addAttribute("searchBookings", searchBookings);
		return "mybookings";
	}

	@RequestMapping(value = "searchMyBookings", method = RequestMethod.POST)
	public String searchMyBookings(
			@ModelAttribute("searchBookings") SearchBookings searchBookings,
			ModelMap model, Principal principal) {
		System.out.println("GolfCourseMember Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		List<Reservationdetails> reservationdetails = new ArrayList<Reservationdetails>();
		Integer searchID = 0;
		try {
			searchID = Integer.parseInt(searchBookings.getSearchText());
			Reservationdetails t = bookingServiceImpl
					.getReservationDetailsByConfirmationID(searchID);
			if (t != null) {
				reservationdetails.add(t);
			}
		} catch (Exception e) {

		}
		SearchBookings temp = new SearchBookings();
		ReservationDetailsList reservationdetailsList = new ReservationDetailsList();
		reservationdetailsList.setReservationDetails(reservationdetails);
		model.addAttribute("reservationdetailsList", reservationdetailsList);
		model.addAttribute("searchBookings", temp);
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
	public String bookTeeTime(HttpServletRequest request, ModelMap model,
			Principal principal) {
		System.out.println("Book tee Time Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		Object obj = request.getAttribute("date-selector-to");
		Date date = null;
		if (obj != null) {
			String temp = (String) obj;
			String[] tokens = temp.split("-");
			int day = Integer.parseInt(tokens[0]);
			int month = Integer.parseInt(tokens[0]);
			int year = Integer.parseInt(tokens[0]);
			date = new Date(year, month + 1, day);
		} else {
			Calendar now = Calendar.getInstance();
			int currmonth = now.get(Calendar.MONTH) + 1;
			int currday = now.get(Calendar.DATE);
			int curryear = now.get(Calendar.YEAR);
			date = new Date(curryear, currmonth, currday);
		}
		// weatherServiceImpl.refreshDB();
		List<HourlyData> hourlyDataList = weatherServiceImpl
				.getHourlyData(date);
		Map<String, HourlyData> hourlyDataMap = new LinkedHashMap<String, HourlyData>();
		for (Iterator iterator = hourlyDataList.iterator(); iterator.hasNext();) {
			HourlyData hourlyData = (HourlyData) iterator.next();
			hourlyDataMap.put(hourlyData.getTimeRange(), hourlyData);
		}
		Map<String, Integer> reservationDetailsMap = new LinkedHashMap<String, Integer>();
		reservationDetailsMap.put("6-7", 0);
		reservationDetailsMap.put("7-8", 0);
		reservationDetailsMap.put("8-9", 0);
		reservationDetailsMap.put("9-10", 0);
		reservationDetailsMap.put("10-11", 0);
		reservationDetailsMap.put("11-12", 0);
		reservationDetailsMap.put("12-13", 0);
		reservationDetailsMap.put("13-14", 0);
		reservationDetailsMap.put("14-15", 0);
		reservationDetailsMap.put("15-16", 0);
		reservationDetailsMap.put("16-17", 0);
		reservationDetailsMap.put("17-18", 0);
		List<Reservationdetails> reservationDetailsList = bookingServiceImpl
				.getReservationDetails(date, user.getGolfcourse()
						.getGolfCourseId());
		for (Iterator iterator = reservationDetailsList.iterator(); iterator
				.hasNext();) {
			Reservationdetails reservationdetails = (Reservationdetails) iterator
					.next();
			String timeRange = reservationdetails.getTimeRange();
			int number = reservationDetailsMap.get(timeRange);
			reservationDetailsMap.put(timeRange,
					number + reservationdetails.getNoOfGolfers());
		}
		List<Capacity> capacityList = capacityServiceImpl
				.getAllCapacitiesByGolfCourseID(user.getGolfcourse()
						.getGolfCourseId());
		Map<String, Integer> capacityMap = new LinkedHashMap<String, Integer>();

		for (Iterator iterator = capacityList.iterator(); iterator.hasNext();) {
			Capacity capacity = (Capacity) iterator.next();
			capacityMap.put(capacity.getTeetime(), capacity.getMaxcount());
		}
		// model.addAttribute("hourlyDataMap", hourlyDataMap);
		model.addAttribute("capacityMap", capacityMap);
		model.addAttribute("hourlyDataMap", hourlyDataMap);
		model.addAttribute("reservationDetailsMap", reservationDetailsMap);
		model.addAttribute("date", date.getDate() + "-" + date.getMonth() + "-"
				+ date.getYear());
		return "booking";
	}

	@RequestMapping(value = "bookteetime", method = RequestMethod.POST)
	public String bookTeeTime1(HttpServletRequest request, ModelMap model,
			Principal principal) {
		System.out.println("Book tee Time Controller\n");
		model.addAttribute("principal", principal);
		Users user = getAuthenticatedUser(principal);
		if (user == null) {
			return "index";
		}
		Object obj = request.getParameter("date-selector-to");
		Date date = null;
		if (obj != null) {
			String temp = (String) obj;
			String[] tokens = temp.split("-");
			int day = Integer.parseInt(tokens[1]);
			int month = Integer.parseInt(tokens[0]);
			int year = Integer.parseInt(tokens[2]);
			date = new Date(year, month - 1, day);
		} else {
			Calendar now = Calendar.getInstance();
			int currmonth = now.get(Calendar.MONTH) + 1;
			int currday = now.get(Calendar.DATE);
			int curryear = now.get(Calendar.YEAR);
			date = new Date(curryear, currmonth, currday);
		}
		// weatherServiceImpl.refreshDB();
		List<HourlyData> hourlyDataList = weatherServiceImpl
				.getHourlyData(date);
		Map<String, HourlyData> hourlyDataMap = new LinkedHashMap<String, HourlyData>();
		for (Iterator iterator = hourlyDataList.iterator(); iterator.hasNext();) {
			HourlyData hourlyData = (HourlyData) iterator.next();
			hourlyDataMap.put(hourlyData.getTimeRange(), hourlyData);
		}
		Map<String, Integer> reservationDetailsMap = new LinkedHashMap<String, Integer>();
		reservationDetailsMap.put("6-7", 0);
		reservationDetailsMap.put("7-8", 0);
		reservationDetailsMap.put("8-9", 0);
		reservationDetailsMap.put("9-10", 0);
		reservationDetailsMap.put("10-11", 0);
		reservationDetailsMap.put("11-12", 0);
		reservationDetailsMap.put("12-13", 0);
		reservationDetailsMap.put("13-14", 0);
		reservationDetailsMap.put("14-15", 0);
		reservationDetailsMap.put("15-16", 0);
		reservationDetailsMap.put("16-17", 0);
		reservationDetailsMap.put("17-18", 0);
		List<Reservationdetails> reservationDetailsList = bookingServiceImpl
				.getReservationDetails(date, user.getGolfcourse()
						.getGolfCourseId());
		for (Iterator iterator = reservationDetailsList.iterator(); iterator
				.hasNext();) {
			Reservationdetails reservationdetails = (Reservationdetails) iterator
					.next();
			String timeRange = reservationdetails.getTimeRange();
			int number = reservationDetailsMap.get(timeRange);
			reservationDetailsMap.put(timeRange,
					number + reservationdetails.getNoOfGolfers());
		}
		List<Capacity> capacityList = capacityServiceImpl
				.getAllCapacitiesByGolfCourseID(user.getGolfcourse()
						.getGolfCourseId());
		Map<String, Integer> capacityMap = new LinkedHashMap<String, Integer>();

		for (Iterator iterator = capacityList.iterator(); iterator.hasNext();) {
			Capacity capacity = (Capacity) iterator.next();
			capacityMap.put(capacity.getTeetime(), capacity.getMaxcount());
		}
		// model.addAttribute("hourlyDataMap", hourlyDataMap);
		model.addAttribute("capacityMap", capacityMap);
		model.addAttribute("hourlyDataMap", hourlyDataMap);
		model.addAttribute("reservationDetailsMap", reservationDetailsMap);
		model.addAttribute("date", (date.getMonth() + 1) + "-" + date.getDate()
				+ "-" + date.getYear());
		return "booking";
	}
}