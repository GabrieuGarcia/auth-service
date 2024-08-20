package com.mammutive.authservice.service;

import com.mammutive.authservice.UserRepository.UserRepository;
import com.mammutive.authservice.enums.Role;
import com.mammutive.authservice.model.AuthenticationRequest;
import com.mammutive.authservice.model.AuthenticationResponse;
import com.mammutive.authservice.model.RegisterRequest;
import com.mammutive.authservice.model.User;
import com.mammutive.authservice.security.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder()
                .username(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .userIdentifier(registerRequest.getUserIdentifier())
                .role(Role.USER)
                .build();

        User userSaved  = userRepository.save(user);
        return this.buildAuthenticationResponse(userSaved);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));

        User user = this.userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return this.buildAuthenticationResponse(user);
    }

    private AuthenticationResponse buildAuthenticationResponse(User user) {
        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
    }


}
