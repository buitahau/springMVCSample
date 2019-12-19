package com.spring.project.web.service;

import com.spring.project.common.dto.RoleDTO;
import com.spring.project.common.dto.UserDTO;
import com.spring.project.manager.UserManager;
import com.spring.project.web.constants.Constants;
import com.spring.project.web.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HauKute on 4/1/2019.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserManager userManager;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName)
                throws UsernameNotFoundException {

        MyUserPrincipal result = null;
        UserDTO userDTO = userManager.loadUserByUsername(userName);
        if (userDTO != null) {
            List<GrantedAuthority> authorityList =
                            getGrantedAuthorities(userDTO.getRoles());
            result = new MyUserPrincipal(userDTO.getUserName(),
                            userDTO.getPassword(), authorityList);
        }
        return result;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<RoleDTO> roles) {

        List<GrantedAuthority> authorityList = new ArrayList<>();
        if (roles != null && roles.size() > 0) {
            for (RoleDTO roleDTO : roles) {
                authorityList.add(
                    new SimpleGrantedAuthority(roleDTO.getRole()));
            }
        }
        authorityList.add(new SimpleGrantedAuthority(
                        Constants.ROLE_USER_DEFAULT));
        return authorityList;
    }

}
