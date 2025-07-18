package com.banking.app.service.impl;

import com.banking.app.repository.CustomUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomUserDetailsRepository customUserDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customUserDetailsRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("user is not present in the database"));
    }
}
