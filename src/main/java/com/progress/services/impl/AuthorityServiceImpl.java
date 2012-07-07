package com.progress.services.impl;

import com.progress.dao.interfaces.AuthorityDao;
import com.progress.dao.interfaces.UserDao;
import com.progress.jpa.Authority;
import com.progress.services.interfaces.AuthorityService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthorityDao authorityDao;

	@Override
	@Transactional
	public Authority getAuthorityByAuthorityId(int authorityId) {
		// TODO Auto-generated method stub
		return authorityDao.getAuthorityByAuthorityId(authorityId);
	}

	@Override
	@Transactional
	public Authority getAuthorityByAuthorityName(String authority) {
		// TODO Auto-generated method stub
		return authorityDao.getAuthorityByAuthorityName(authority);
	}

	@Override
	@Transactional
	public void addAuthority(Authority authority) {
		authorityDao.addAuthority(authority);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<Authority> getAll() {
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