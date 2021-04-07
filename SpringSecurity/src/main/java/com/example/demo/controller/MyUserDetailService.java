package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailService  implements UserDetailsService{

	@Autowired
	private UserDetailRepo userDetailRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// here i want to get userDetail from my user repo or data base and load into them
		UserDetail user=userDetailRepo.findUserByemailid(username);
		
		return new User(user.getEmailid(), user.getPassword(),new  ArrayList<> ());
	}

}
