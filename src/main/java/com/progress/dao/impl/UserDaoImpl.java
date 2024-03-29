package com.progress.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.progress.dao.interfaces.UserDao;
import com.progress.jpa.Authorities;
import com.progress.jpa.Users;

/**
 * 
 * @author agoel
 * 
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private String getByUserNamequeryString = "from Users where username = ?";
	private String getByUserIDqueryString = "from Users where userID = ?";

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private void initJoinObjects(Users u) {
		Hibernate.initialize(u.getAuthority());
		Hibernate.initialize(u.getReservationdetailses());
		Hibernate.initialize(u.getGolfcourse());
	}

	@Override
	@Transactional
	public Users getUserByUserName(String userName) throws HibernateException {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("Entering getUserbyUserName: " + userName + "\n");
		Query query = session.createQuery(getByUserNamequeryString);
		query.setString(0, userName);
		List<Users> result = query.list();
		if (result == null || result.size() == 0) {
			System.out.println("No search results\n");
			return null;
		}
		System.out.println(result);
		System.out.println("sessionfactory working\n");
		Users u = result.get(0);
		initJoinObjects(u);
		System.out.println(u);
		return u;
	}

	/**
	 * The following function/method is used by UserUserDetails Service.java for
	 * security(authentication) purposes. This is done using services provided
	 * by UserService.java which used UserDaoImpl for the funtioning part.
	 **/
	@Override
	@Transactional
	public List<String> getAuthoritiesByUserName(String userName) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			System.out.println("Entering getAuthoritiesbyUserName: " + userName
					+ "\n");
			System.out
					.println("Entering getUserbyUserName: " + userName + "\n");
			Query query = session.createQuery(getByUserNamequeryString);
			query.setString(0, userName);

			List<Users> result = query.list();
			if (result == null || result.size() == 0) {
				System.out.println("No search results\n");
				return null;
			}
			System.out.println(result);
			System.out.println("sessionfactory working\n");
			Users u = result.get(0);
			Authorities a = u.getAuthority();
			String auth = a.getAuthority();
			List<String> l = new ArrayList<String>();
			l.add(auth);
			return l;
		} catch (HibernateException ex) {
			System.out.println("error in query string\n");
			return null;
		}
	}

	@Override
	@Transactional
	public List<Users> getAll() {
		System.out.println("get all users details - 1\n");
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("get all users details\n");
		Query query = session.createQuery("from users");
		List<Users> result = query.list();
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Users users = (Users) iterator.next();
			initJoinObjects(users);
		}
		return result;
	}

	@Override
	@Transactional
	public void addLogin(Users user) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Entering addLogin in daoimpl\n");
		session.saveOrUpdate(user);
		System.out.println("done addLogin in daoimpl\n");
		return;
	}

	@Override
	@Transactional
	public void updateUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Entering addLogin in daoimpl\n");
		session.saveOrUpdate(user);
		System.out.println("done addLogin in daoimpl\n");
		return;
	}

	@Override
	@Transactional
	public Users getUserByUserID(int userID) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(getByUserIDqueryString);
		query.setInteger(0, userID);
		List<Users> result = query.list();
		if (result == null || result.size() == 0) {
			System.out.println("No search results\n");
			return null;
		}
		System.out.println(result);
		System.out.println("sessionfactory working\n");
		Users u = result.get(0);
		initJoinObjects(u);
		System.out.println(u);
		return u;
	}
}