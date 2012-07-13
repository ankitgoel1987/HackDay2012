package com.progress.dao.interfaces;

import java.util.List;

import com.progress.jpa.Authorities;

/**
 * 
 * @author agoel
 *
 */
public interface AuthorityDao {

	public Authorities getAuthorityByAuthorityId(int authorityId);

	public Authorities getAuthorityByAuthorityName(String authority);

	public List<Authorities> getAll();

	public void addAuthority(Authorities authority);

}
