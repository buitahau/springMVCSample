package com.spring.project.web.listener;

import com.spring.project.common.dto.RoleDTO;
import com.spring.project.common.dto.UserDTO;
import com.spring.project.common.enums.StatusEnum;
import com.spring.project.manager.UserManager;
import com.spring.project.web.constants.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by HauKute on 12/18/2019.
 */

public class StartupListener implements InitializingBean {

	@Override
	public void afterPropertiesSet()
					throws Exception {

		initData();
	}

	/**
	 * Count users, if = 0, create default admin user
	 */
	private void initData() {

		int totalUsers = userManager.countAll();
		logger.info("Init Sample Data");

		if (totalUsers == 0) {
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setRole(Constants.ROLE_ADMIN_DEFAULT);
			List<RoleDTO> roles = new ArrayList<>();
			roles.add(roleDTO);

			UserDTO userDTO = new UserDTO();
			userDTO.setStatus(StatusEnum.ACTIVE.getValue());
			userDTO.setPassword(DEFAULT_ADMIN_PASSWORD);
			userDTO.setUserName(DEFAULT_ADMIN_USERNAME);
			userDTO.setRoles(roles);
			userManager.addUser(userDTO);
		}
	}

	@Autowired
	private UserManager userManager;

	private static final String DEFAULT_ADMIN_USERNAME = "admin";

	private static final String DEFAULT_ADMIN_PASSWORD = "123456";

	private static final Logger logger =
					Logger.getLogger(StartupListener.class);
}
