package com.spring.project.web.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by HauKute on 11/27/2019.
 */
public class Test {
	public static void main(String[] args) {
		int i = 0;
		while (i < 10) {
			String password = "123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}
	}
}
