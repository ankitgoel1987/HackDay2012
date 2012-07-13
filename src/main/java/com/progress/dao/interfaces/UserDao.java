package com.progress.dao.interfaces;

import java.util.List;

import com.progress.jpa.Users;

/**
 * 
 * @author agoel
 *
 */
public interface UserDao {
	public Users getUserByUserName(String userName);

	public List<String> getAuthoritiesByUserName(String userName);

	public List<Users> getAll();

	public void addLogin(Users user);
}