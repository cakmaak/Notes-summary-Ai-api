package com.ai_note_api.ainoteapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai_note_api.ainoteapi.Dto.AuthResponse;
import com.ai_note_api.ainoteapi.Dto.LoginRequestDto;
import com.ai_note_api.ainoteapi.Dto.SignupRequestDto;
import com.ai_note_api.ainoteapi.Entity.User;
import com.ai_note_api.ainoteapi.Security.JwtService;
import com.ai_note_api.ainoteapi.Service.IUserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ainoteapi")
public class UserControllerimpl implements IUserController {
	
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("/signup")
	@Operation(summary = " signup a new user",description = "")
	@Override
	public User signup(@RequestBody SignupRequestDto signupRequestDto) {
		return userService.signup(signupRequestDto);
		
	}

	@PostMapping("/login")
	@Operation(summary = "Login and get JWT token", description = "")
	@Override
	public AuthResponse login(@RequestBody LoginRequestDto loginRequestDto) {
		Authentication authentication=authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
		String token = jwtService.generateToken(loginRequestDto.getEmail());
		return new AuthResponse(token);
	}
	
	@PostMapping("/saveadmin")
	@Operation(summary = "save admin for admins")
	@Override
	public User saveAdmin(@RequestBody SignupRequestDto signupRequestDto) {
		
		return userService.saveAdmin(signupRequestDto);
		
	}
	
	

}
