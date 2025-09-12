package com.ai_note_api.ainoteapi.Dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    public AuthResponse(String token){ this.token = token; }
    public String getToken(){ return token; }
}