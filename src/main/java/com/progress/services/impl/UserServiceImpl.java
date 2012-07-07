package com.progress.services.impl;

import com.progress.dao.interfaces.UserDao;
import com.progress.jpa.User;
import com.progress.services.interfaces.UserService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public User getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

	@Override
	@Transactional
	public List<String> getAuthoritiesByUserName(String userName) {
		return userDao.getAuthoritiesByUserName(userName);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public List<User> getAll() {
		System.out.println("check number 1\n");
		return userDao.getAll();
	}

	@Override
	@Transactional
	public void addLogin(User user) {
		userDao.addLogin(user);
		return;
	}
}