package com.progress.services.interfaces;

import java.util.List;

import com.progress.jpa.Authorities;

/**
 * 
 * @author agoel
 * 
 */
public interface AuthorityService {
	public abstract Authorities getAuthorityByAuthorityId(int authorityId);

	public abstract Authorities getAuthorityByAuthorityName(String authority);

	public abstract List<Authorities> getAll();

	public abstract void addAuthority(Authorities authority);
}