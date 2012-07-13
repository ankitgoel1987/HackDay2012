package com.progress.services.impl;

import com.progress.jpa.Users;
import com.progress.services.interfaces.UserService;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 
 * @author agoel
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {
	private UserService userService;

	public UserDetailsServiceImpl(UserService userService) {
		this.userService = userService;
	}

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		Users user;
		try {
			user = userService.getUserByUserName(userName);
		} catch (Exception e) {
			throw new UsernameNotFoundException(
					"getUserByUserName returned null.");
		}
		if(user == null) {
			throw new UsernameNotFoundException("Invalid user name");
		}
		List<String> authorities = userService
				.getAuthoritiesByUserName(userName);
		user.setUserAuthorities(authorities);
		return (UserDetails) user;
	}
}