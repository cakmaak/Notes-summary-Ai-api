package com.ai_note_api.ainoteapi.Controller;

import com.ai_note_api.ainoteapi.Dto.AuthResponse;
import com.ai_note_api.ainoteapi.Dto.LoginRequestDto;
import com.ai_note_api.ainoteapi.Dto.SignupRequestDto;
import com.ai_note_api.ainoteapi.Entity.User;

public interface IUserController {
	
	public User signup(SignupRequestDto signupRequestDto);
	public AuthResponse login(LoginRequestDto loginRequestDto);
	public User saveAdmin(SignupRequestDto signupRequestDto);

}
