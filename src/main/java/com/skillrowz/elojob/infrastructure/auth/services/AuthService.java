package com.skillrowz.elojob.infrastructure.auth.services;

import com.skillrowz.elojob.infrastructure.auth.entities.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(String email, String password) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        var auth = authenticationManager.authenticate(authenticationToken);

        return jwtService.generateToken((UserDetailsImpl) auth.getPrincipal());
    }
}
