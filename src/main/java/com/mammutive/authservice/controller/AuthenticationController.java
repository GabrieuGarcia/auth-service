package com.mammutive.authservice.controller;

import com.mammutive.authservice.dto.AuthenticationRequestDto;
import com.mammutive.authservice.dto.AuthenticationResponseDto;
import com.mammutive.authservice.dto.RegisterRequestDto;
import com.mammutive.authservice.mapper.AuthenticationRequesMapper;
import com.mammutive.authservice.mapper.RegisterRequestMapper;
import com.mammutive.authservice.service.AuthenticationService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Resource
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final RegisterRequestMapper registerRequestMapper;
    private final AuthenticationRequesMapper authenticationRequesMapper;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterRequestDto requestDto) {
        return null;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationRequestDto requestDto) {
        return null;
    }

}
