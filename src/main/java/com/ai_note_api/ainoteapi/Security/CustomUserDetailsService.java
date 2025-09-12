package com.ai_note_api.ainoteapi.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.ai_note_api.ainoteapi.Service.IUserService;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Lazy
	@Autowired
	IUserService userService;
	

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.ai_note_api.ainoteapi.Entity.User u = userService.getUserbyEmail(email);
        if (u == null) throw new UsernameNotFoundException("User not found: " + email);

        
        return org.springframework.security.core.userdetails.User
                .withUsername(u.getEmail())
                .password(u.getPassword()) 
                .authorities(List.of())
                .accountExpired(false).accountLocked(false)
                .credentialsExpired(false).disabled(false)
                .build();
    }
}
