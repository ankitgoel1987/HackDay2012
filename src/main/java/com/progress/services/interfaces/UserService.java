package com.progress.services.interfaces;

import java.util.List;

import com.progress.jpa.Users;

/**
 * 
 * @author agoel
 * 
 */
public interface UserService {
	public Users getUserByUserName(String userName);

	public Users getUserByUserID(int userID);
	
	public List<String> getAuthoritiesByUserName(String userName);

	public List<Users> getAll();

	public void addLogin(Users user);
	
	public void updateUser(Users user);

}