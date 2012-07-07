package com.progress.services.interfaces;
import java.util.List;

import com.progress.jpa.User;

public interface UserService {
	public abstract User getUserByUserName(String userName);
	public abstract List<String> getAuthoritiesByUserName(String userName);
    public abstract List<User> getAll();
	public abstract void addLogin(User user);
}