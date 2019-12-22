package com.spring.project.web.listener;

import com.spring.project.common.dto.RoleDTO;
import com.spring.project.common.dto.UserDTO;
import com.spring.project.common.enums.StatusEnum;
import com.spring.project.manager.UserManager;
import com.spring.project.web.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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

	private UserDTO createUserDTOFromUsernameAndPassword(
					String userName, String password) {

		UserDTO userDTO = new UserDTO();
		userDTO.setStatus(StatusEnum.ACTIVE.getValue());
		userDTO.setUserName(userName);
		userDTO.setPassword(password);
		return userDTO;
	}

	/**
	 * Count users, if = 0, create default admin user
	 */
	private void initData() {

		int totalUsers = userManager.countAll();

		if (totalUsers > 0 || StringUtils.isBlank(DEFAULT_ADMIN_USERNAME) ||
						StringUtils.isBlank(DEFAULT_ADMIN_PASSWORD) ||
						StringUtils.isBlank(DEFAULT_USER_USERNAME) ||
						StringUtils.isBlank(DEFAULT_USER_PASSWORD)) {

			return;
		}

		logger.info("Begin initializing the sample data...");
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setRole(Constants.ROLE_ADMIN_DEFAULT);
		List<RoleDTO> roles = new ArrayList<>();
		roles.add(roleDTO);

		UserDTO userAdminDTO = createUserDTOFromUsernameAndPassword(
						DEFAULT_ADMIN_USERNAME, DEFAULT_ADMIN_PASSWORD);
		userAdminDTO.setRoles(roles);
		userManager.addUser(userAdminDTO);

		UserDTO userDTO = createUserDTOFromUsernameAndPassword(
						DEFAULT_USER_USERNAME, DEFAULT_USER_PASSWORD);
		userManager.addUser(userDTO);

		logger.info("...End initializing the sample data!");
	}

	@Autowired
	private UserManager userManager;

	@Value("${default.admin.username}")
	private String DEFAULT_ADMIN_USERNAME;

	@Value("${default.admin.password}")
	private String DEFAULT_ADMIN_PASSWORD;

	@Value("${default.user.username}")
	private String DEFAULT_USER_USERNAME;

	@Value("${default.user.password}")
	private String DEFAULT_USER_PASSWORD;

	private static final Logger logger =
					Logger.getLogger(StartupListener.class);
}
