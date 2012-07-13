package com.progress.services.interfaces;

import java.util.List;

import com.progress.jpa.Users;

/**
 * 
 * @author agoel
 * 
 */
public interface UserService {
	public abstract Users getUserByUserName(String userName);

	public abstract List<String> getAuthoritiesByUserName(String userName);

	public abstract List<Users> getAll();

	public abstract void addLogin(Users user);
}