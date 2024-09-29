package com.nikhil.blogapp.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class JwtAuthResponse {
    private String token;
    public JwtAuthResponse(String token) {
        this.token = token;
    }
}
