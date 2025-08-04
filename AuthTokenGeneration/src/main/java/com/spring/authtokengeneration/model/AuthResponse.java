package com.spring.authtokengeneration.model;

import lombok.Getter;

@Getter
public class AuthResponse {
    private final String token;

    public AuthResponse(String token) {
        this.token = token;
    }

}
