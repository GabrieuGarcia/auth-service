package com.mammutive.authservice.service;

import com.mammutive.authservice.model.AuthenticationRequest;
import com.mammutive.authservice.model.AuthenticationResponse;
import com.mammutive.authservice.model.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

}
