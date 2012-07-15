package com.progress.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.progress.dao.interfaces.ReservationDetailsDao;
import com.progress.jpa.Reservationdetails;

/**
 * 
 * @author agoel
 * 
 */
@Repository
public class ReservationDetailsDaoImpl implements ReservationDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	private String getAllQueryString = "from Reservationdetails";
	private String getByConfirmationIDQueryString = "from Reservationdetails where confirmationNumber = ?";

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Reservationdetails> getReservationDetailsByUserID(int userID) {
		System.out.println("getReservationDetailsByUserID");
		List<Reservationdetails> filteredReservationdetails = new ArrayList<Reservationdetails>();
		try {
			List<Reservationdetails> allReservationdetails = getAllReservationDetails();
			for (Reservationdetails temp : allReservationdetails) {
				if (temp.getUsers().getUserId() == userID) {
					filteredReservationdetails.add(temp);
				}
			}
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
		return filteredReservationdetails;
	}

	@Override
	@Transactional
	public List<Reservationdetails> getAllReservationDetails() {
		System.out.println("getAllReservationDetails\n");
		List<Reservationdetails> reservationdetails = new ArrayList<Reservationdetails>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(getAllQueryString);
			reservationdetails = query.list();
			if (reservationdetails != null && reservationdetails.size() != 0) {
				for (Reservationdetails temp : reservationdetails) {
					Hibernate.initialize(temp.getUsers());
					Hibernate.initialize(temp.getGolfcourse());
				}
			}
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
		return reservationdetails;
	}

	@Override
	@Transactional
	public Reservationdetails getReservationDetailsByConfirmationID(
			int conformationID) {
		System.out.println("getReservationDetailsByConfirmationID - 1\n");
		Reservationdetails reservationDetails = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(getByConfirmationIDQueryString);
			query.setInteger(0, conformationID);
			List<Reservationdetails> reservationdetails = query.list();
			if (reservationdetails != null && reservationdetails.size() != 0) {
				reservationDetails = reservationdetails.get(0);
				Hibernate.initialize(reservationDetails.getUsers());
				Hibernate.initialize(reservationDetails.getGolfcourse());
			}

		} catch (HibernateException ex) {
			System.err.println(ex);
		}
		return reservationDetails;
	}

	@Override
	@Transactional
	public void addReservationDetail(Reservationdetails reservationdetails) {
		System.out.println("addReservationDetail");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(reservationdetails);
		} catch (HibernateException ex) {
			System.err.println(ex);
		}

	}

	@Override
	@Transactional
	public void cancelReservation(int conformationID) {
		System.out.println("cancelReservation");
		try {
			Session session = sessionFactory.getCurrentSession();
			Reservationdetails reservationDetails = getReservationDetailsByConfirmationID(conformationID);
			reservationDetails.setStatus(0);
			session.saveOrUpdate(reservationDetails);
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
	}
}