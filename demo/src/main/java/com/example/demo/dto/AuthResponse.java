package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String tokenType = "Bearer";

    // Constructor chỉ nhận token
    public AuthResponse(String token) {
        this.token = token;
        this.tokenType = "Bearer";
    }
}