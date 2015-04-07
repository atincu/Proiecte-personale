package com.taskmanager.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taskmanager.dao.UserDao;
import com.taskmanager.model.RoleEntity;
import com.taskmanager.model.UserEntity;
import com.taskmanager.model.UserStatus;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDao userDao;
	
	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		UserEntity user = userDao.findUserByName(username);
		
		if (user != null){
			
			String password = user.getPassword();
			boolean enabled = user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
			boolean credentialsNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonLocked = user.getStatus().equals(UserStatus.ACTIVE);
			
			Collection <GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (RoleEntity role : user.getRoles()){
				authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
			}
			
			org.springframework.security.core.userdetails.User securityUser = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("User Not Found!!!!");
		}
	}

}
