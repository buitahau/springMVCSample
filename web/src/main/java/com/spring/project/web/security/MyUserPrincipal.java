package com.spring.project.web.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * Created by HauKute on 4/1/2019.
 */
public class MyUserPrincipal extends User {

	public MyUserPrincipal(
					String username, String password,
					List<GrantedAuthority> authorities) {

		super(username, password, authorities);
	}
}
