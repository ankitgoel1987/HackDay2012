package com.progress.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.progress.dao.interfaces.CapacityDao;
import com.progress.jpa.Capacity;

public class CapacityDaoImpl implements CapacityDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	private String getCapacityByID = "from Capacity where golfCourseID = ?";
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	@Transactional
	public List<Capacity> getAllCapacitiesByGolfCourseID(int id) {
		List<Capacity> capacityList = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(getCapacityByID);
			query.setInteger(0, id);
			capacityList = query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
		return capacityList;
	}
}
