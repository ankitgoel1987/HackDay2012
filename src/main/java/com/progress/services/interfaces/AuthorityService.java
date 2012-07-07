package com.progress.services.interfaces;
import java.util.List;

import com.progress.jpa.Authority;

public interface AuthorityService {
	public abstract Authority getAuthorityByAuthorityId(int authorityId);
	public abstract Authority getAuthorityByAuthorityName(String authority);
    public abstract List<Authority> getAll();
	public abstract void addAuthority(Authority authority);
}