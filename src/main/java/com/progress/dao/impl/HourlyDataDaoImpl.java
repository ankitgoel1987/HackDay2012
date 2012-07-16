package com.progress.dao.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.progress.dao.interfaces.HourlyDataDao;
import com.progress.jpa.HourlyData;

/**
 * 
 * @author agoel
 * 
 */
@Repository
public class HourlyDataDaoImpl implements HourlyDataDao {

	@Autowired
	private SessionFactory sessionFactory;

	private String getHourlyDataByDateQueryString = "from HourlyData where date =?";

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<HourlyData> getHourlyData(Date date) {
		System.out.println("getHourlyData - 1\n");
		List<HourlyData> hourlyDataList = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(getHourlyDataByDateQueryString);
			query.setString(0, date.getDate() + "-" + (date.getMonth()) + "-"
					+ date.getYear());
			hourlyDataList = query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
		return hourlyDataList;
	}

	@Override
	@Transactional
	public void saveHourlyData(List<HourlyData> hourlyDataList) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			System.out.println("SESSION:"+session);
			for (Iterator iterator = hourlyDataList.iterator(); iterator
					.hasNext();) {
				HourlyData hourlyData = (HourlyData) iterator.next();
				session.saveOrUpdate(hourlyData);
			}
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
	}
}