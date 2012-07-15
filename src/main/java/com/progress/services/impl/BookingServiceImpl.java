package com.progress.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.dao.interfaces.ReservationDetailsDao;
import com.progress.jpa.Reservationdetails;
import com.progress.services.interfaces.BookingService;

/**
 * 
 * @author agoel
 * 
 */
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	ReservationDetailsDao reservationDetailsDao;

	public void setReservationDetailsDao(ReservationDetailsDao reservationDetailsDao) {
		this.reservationDetailsDao = reservationDetailsDao;
	}

	@Override
	public List<Reservationdetails> getReservationDetailsByUserID(int userID) {
		return reservationDetailsDao.getReservationDetailsByUserID(userID);
	}

	@Override
	public List<Reservationdetails> getAllReservationDetails() {
		return reservationDetailsDao.getAllReservationDetails();
	}

	@Override
	public Reservationdetails getReservationDetailsByConfirmationID(
			int conformationID) {
		return reservationDetailsDao
				.getReservationDetailsByConfirmationID(conformationID);
	}

	@Override
	public void addReservationDetail(Reservationdetails reservationdetails) {
		reservationDetailsDao.addReservationDetail(reservationdetails);
	}

	@Override
	public void cancelReservation(int conformationID) {
		reservationDetailsDao.cancelReservation(conformationID);
	}
}