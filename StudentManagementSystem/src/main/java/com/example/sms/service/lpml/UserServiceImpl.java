package com.example.sms.service.lpml;

import java.util.Arrays;
//import java.util.Collection;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Role;
import com.example.sms.entity.User;
import com.example.sms.repository.UserRepository;
import com.example.sms.service.UserService;
import com.example.sms.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepositoy) {
		super();
		this.userRepository = userRepositoy;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user=new User(registrationDto.getUserFirstName(),
				registrationDto.getUserLastName(),
				registrationDto.getUserEmail(),
				//passwordEncoder.encode(registrationDto.getUserPassword()),
				registrationDto.getUserPassword(),
				Arrays.asList(new Role("ROLE_USER"))
				);
		
		return userRepository.save(user);
	}

	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(),user.getUserPassword(),mapRolesToAuthorities(user.getUserRole()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}
	*/
	/*
	@Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
	=
	@Override
    public User findByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }
	*/
}

