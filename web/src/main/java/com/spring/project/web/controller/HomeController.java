package com.spring.project.web.controller;

import com.spring.project.manager.UserManager;
import com.spring.project.web.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HauKute on 3/16/2019.
 */
@Controller
public class HomeController {

	@Autowired
	private UserManager userManager;

	@RequestMapping(value = {"/", "/user"}, method = RequestMethod.GET)
	public String dashboard(Model model) {

		model.addAttribute("userName", SecurityUtils.getPrincipal().getUsername());
		return "user/index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {

		model.addAttribute("userName", SecurityUtils.getPrincipal().getUsername());
		return "admin/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "common/login";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String loginError(ModelMap model) {

		return "common/denied";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "common/logout";
	}
}




