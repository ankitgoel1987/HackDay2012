package com.progress.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.progress.dao.interfaces.AuthorityDao;
import com.progress.jpa.Authorities;

/**
 * 
 * @author agoel
 *
 */
@Repository
public class AuthorityDaoImpl implements AuthorityDao {

	@Autowired
	private SessionFactory sessionFactory;
	private String queryString = "from Authorities where authorityID = ?";

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Authorities getAuthorityByAuthorityId(int authorityId)
			throws HibernateException {

		Session session = this.sessionFactory.getCurrentSession();

		try {

			System.out.println("Entering getAuthorityByAuthorityId: "
					+ authorityId + "\n");
			Query query = session.createQuery(queryString);
			query.setInteger(0, authorityId);

			List<Authorities> result = query.list();
			if (result == null) {
				System.out.println("No search results\n");
				return null;
			}
			System.out.println(result);
			System.out.println("sessionfactory working\n");
			Authorities a = result.get(0);
			System.out.println(a);
			return a;
		} catch (HibernateException ex) {
			throw new HibernateException(ex);
		}
	}

	@Override
	@Transactional
	public Authorities getAuthorityByAuthorityName(String authority)
			throws HibernateException {

		Session session = this.sessionFactory.getCurrentSession();

		try {

			System.out.println("Entering getAuthorityByAuthorityName: "
					+ authority + "\n");
			Query query = session
					.createQuery("from Authorities where authority = ?");
			query.setString(0, authority);

			List<Authorities> result = query.list();
			if (result == null) {
				System.out.println("No search results\n");
				return null;
			}
			System.out.println(result);
			System.out.println("sessionfactory working\n");
			Authorities a = result.get(0);
			System.out.println(a);
			return a;
		} catch (HibernateException ex) {
			throw new HibernateException(ex);
		}
	}

	@Override
	@Transactional
	public List<Authorities> getAll() {
		System.out.println("get all authorities details\n");
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Authorities");
		List<Authorities> result = query.list();
		return result;
	}

	@Override
	@Transactional
	public void addAuthority(Authorities authority) {
		Session session = sessionFactory.getCurrentSession();

		Authorities a = null;
		a.setAuthorityId(authority.getAuthorityId());
		a.setAuthority(authority.getAuthority());
		session.saveOrUpdate(a);

		return;
	}
}