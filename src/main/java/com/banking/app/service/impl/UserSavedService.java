package com.banking.app.service.impl;

import com.banking.app.entity.Users;
import com.banking.app.payload.UserPayload;
import com.banking.app.repository.CustomUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSavedService {

    @Autowired
    private CustomUserDetailsRepository userDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String savedUser(UserPayload userPayload){
        Users users = new Users();
        users.setUsername(userPayload.getUserName());
        users.setPassword(userPayload.getPassword());
        users.setRole("Admin");
        userDetailsRepository.save(users);
        return "Successfully saved";
    }
}
