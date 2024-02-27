package com.medianet.AgenceApplication.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String accessToken;
    private String TokenType = "Bearer ";

    public AuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
