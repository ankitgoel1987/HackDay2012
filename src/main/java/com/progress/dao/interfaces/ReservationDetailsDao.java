package com.progress.dao.interfaces;

import java.util.List;

import com.progress.jpa.Reservationdetails;

/**
 * 
 * @author agoel
 * 
 */
public interface ReservationDetailsDao {

	public List<Reservationdetails> getReservationDetailsByUserID(int userID);

	public List<Reservationdetails> getAllReservationDetails();

	public Reservationdetails getReservationDetailsByConfirmationID(
			int conformationID);

	public void addReservationDetail(Reservationdetails reservationdetails);

	public void cancelReservation(int conformationID);

}
