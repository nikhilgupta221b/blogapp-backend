package com.nikhil.blogapp.controllers;

import com.nikhil.blogapp.payloads.JwtAuthRequest;
import com.nikhil.blogapp.payloads.JwtAuthResponse;
import com.nikhil.blogapp.security.CustomUserDetailService;
import com.nikhil.blogapp.security.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @PostMapping("/api/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthRequest authRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = customUserDetailService.loadUserByUsername(authRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtAuthResponse(jwt));
    }
}
