package com.example.sms.service;

//import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.sms.entity.User;
import com.example.sms.web.dto.UserRegistrationDto;

/*
public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
*/
public interface UserService{
	//User findByUserEmail(String userEmail);
	User save(UserRegistrationDto registrationDto);
}