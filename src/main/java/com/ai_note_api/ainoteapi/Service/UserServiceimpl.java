package com.ai_note_api.ainoteapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ai_note_api.ainoteapi.Dto.SignupRequestDto;
import com.ai_note_api.ainoteapi.Entity.User;
import com.ai_note_api.ainoteapi.Enums.Role;
import com.ai_note_api.ainoteapi.Repository.UserRepository;

@Service
public class UserServiceimpl implements IUserService {

    @Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;

 

	@Override
	public User getUserbyEmail(String email) {
		System.out.println("searching db (IgnoreCase): " + email);

	    Optional<User> userOpt = userRepository.findByEmailIgnoreCase(email.trim());

	    if(userOpt.isPresent()) {
	        User user = userOpt.get();

	        System.out.println("user found: " + user.getEmail());

	        return user;
	    } else {
	        throw new RuntimeException("user not found");
	    }
		
		
	}

	@Override
	public User signup(SignupRequestDto signupRequestDto) {
	User user=new User();
	user.setEmail(signupRequestDto.getEmail());
	user.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
	user.setRole(Role.AGENT);
	userRepository.save(user);
	return user;
		
		
	}

	@Override
	public User saveAdmin(SignupRequestDto signupRequestDto) {
		User user=new User();
		user.setEmail(signupRequestDto.getEmail());
		user.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
		user.setRole(Role.ADMIN);
		userRepository.save(user);
	
	   return user;
	    
	}

	
	}


