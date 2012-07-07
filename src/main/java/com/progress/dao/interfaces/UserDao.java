package com.progress.dao.interfaces;

import java.util.List;

import com.progress.jpa.User;

public interface UserDao {
	public User getUserByUserName(String userName);

	public List<String> getAuthoritiesByUserName(String userName);

	public List<User> getAll();

	public void addLogin(User user);
}