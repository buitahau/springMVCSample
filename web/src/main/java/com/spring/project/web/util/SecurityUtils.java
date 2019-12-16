package com.spring.project.web.util;

import com.spring.project.web.security.MyUserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by HauKute on 5/4/2019.
 */
public class SecurityUtils {

	public static MyUserPrincipal getPrincipal() {

		return (MyUserPrincipal) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
	}
}
