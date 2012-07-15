package com.progress.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progress.dao.interfaces.UserDao;
import com.progress.jpa.Users;
import com.progress.services.interfaces.UserService;

/**
 * 
 * @author agoel
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public Users getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}
	
	@Override
	@Transactional
	public Users getUserByUserID(int userID) {
		return userDao.getUserByUserID(userID);
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
	public List<Users> getAll() {
		System.out.println("check number 1\n");
		return userDao.getAll();
	}

	@Override
	@Transactional
	public void addLogin(Users user) {
		userDao.addLogin(user);
		return;
	}
	
	@Override
	@Transactional
	public void updateUser(Users user) {
		userDao.updateUser(user);
		return;
	}
}