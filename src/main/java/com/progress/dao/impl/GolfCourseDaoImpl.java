package com.progress.dao.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.progress.dao.interfaces.GolfCourseDao;
import com.progress.jpa.Golfcourse;

public class GolfCourseDaoImpl implements GolfCourseDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private String getGolfCourseByID = "from Golfcourse where golfCourseID = ?";
	private String getAllGolfCourses = "from Golfcourse";
	private String getGolfCourseByname = "from Golfcourse where name LIKE %?% ";
	
	@Override
	@Transactional
	public List<Golfcourse> getAllGolfCourses() {		
		List<Golfcourse> golfCourses = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(getAllGolfCourses);
			golfCourses = query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
		return golfCourses;
	}
	
	@Override
	@Transactional
	public void addGolfCourse(Golfcourse g) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(g);
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
	}
	
	@Override
	@Transactional
	public Golfcourse getGolfCourseByID(int golfCourseID) {
		List<Golfcourse> golfCourseList = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(getGolfCourseByID);
			query.setInteger(0, golfCourseID);
			golfCourseList = query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
		return golfCourseList.get(0);
	}
	
	@Override
	@Transactional
	public List<Golfcourse> searchGolfCourseByName(String golfCourseName) {
		List<Golfcourse> golfCourseList = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(getGolfCourseByname);
			query.setString(0, golfCourseName);
			golfCourseList = query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
		return golfCourseList;
	}

	@Override
	@Transactional
	public Golfcourse getGolfCourseByName(String golfCourseName) {
		List<Golfcourse> golfCourseList = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery(getGolfCourseByname);
			query.setString(0, golfCourseName);
			golfCourseList = query.list();
		} catch (HibernateException ex) {
			System.err.println(ex);
		}
		return golfCourseList.get(0);
	}
}
