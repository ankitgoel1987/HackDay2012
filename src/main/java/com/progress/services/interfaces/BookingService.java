package com.progress.services.interfaces;

import java.util.List;

import com.progress.jpa.Reservationdetails;
import com.progress.jpa.Users;

/**
 * 
 * @author agoel
 * 
 */
public interface BookingService {

	public List<Reservationdetails> getReservationDetailsByUserID(int userID);

	public List<Reservationdetails> getAllReservationDetails();

	public Reservationdetails getReservationDetailsByConfirmationID(
			int conformationID);

	public void addReservationDetail(Reservationdetails reservationdetails);

}