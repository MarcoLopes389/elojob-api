package com.skillrowz.elojob.infrastructure.auth.services;

import com.skillrowz.elojob.domain.repositories.UserRepository;
import com.skillrowz.elojob.infrastructure.auth.entities.UserDetailsImpl;
import com.skillrowz.elojob.infrastructure.auth.exceptions.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username);
        var gettedUser = user.orElseThrow(() -> new AuthenticationException("Usuário não encontrado"));

        return new UserDetailsImpl(gettedUser);
    }
}
