package com.ai_note_api.ainoteapi.Service;

import com.ai_note_api.ainoteapi.Dto.LoginRequestDto;
import com.ai_note_api.ainoteapi.Dto.SignupRequestDto;
import com.ai_note_api.ainoteapi.Entity.User;

public interface IUserService {
	
	
	public User getUserbyEmail(String email);
	public User signup(SignupRequestDto signupRequestDto);
	public User saveAdmin(SignupRequestDto signupRequestDto);
	
	

}
