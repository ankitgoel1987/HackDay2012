package com.progress.dao.interfaces;

import java.util.List;

import com.progress.jpa.Authority;

public interface AuthorityDao {

	public Authority getAuthorityByAuthorityId(int authorityId);

	public Authority getAuthorityByAuthorityName(String authority);

	public List<Authority> getAll();

	public void addAuthority(Authority authority);

}
