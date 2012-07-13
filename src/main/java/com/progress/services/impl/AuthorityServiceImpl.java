package com.progress.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progress.dao.interfaces.AuthorityDao;
import com.progress.jpa.Authorities;
import com.progress.services.interfaces.AuthorityService;

/**
 * 
 * @author agoel
 *
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthorityDao authorityDao;

	@Override
	@Transactional
	public Authorities getAuthorityByAuthorityId(int authorityId) {
		// TODO Auto-generated method stub
		return authorityDao.getAuthorityByAuthorityId(authorityId);
	}

	@Override
	@Transactional
	public Authorities getAuthorityByAuthorityName(String authority) {
		// TODO Auto-generated method stub
		return authorityDao.getAuthorityByAuthorityName(authority);
	}

	@Override
	@Transactional
	public void addAuthority(Authorities authority) {
		authorityDao.addAuthority(authority);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<Authorities> getAll() {
		// TODO Auto-generated method stub
		return authorityDao.getAll();
	}

	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}
}