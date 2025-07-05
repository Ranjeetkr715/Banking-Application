package com.banking.app.service.impl;

import com.banking.app.entity.Role;
import com.banking.app.entity.Users;
import com.banking.app.payload.UserCreatePayload;
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

    public String savedUser(UserCreatePayload userCreatePayload){
        Users users = new Users();
        users.setUsername(userCreatePayload.getUserName());
        users.setPassword(passwordEncoder.encode(userCreatePayload.getPassword()));
        if("ADMIN".equalsIgnoreCase(userCreatePayload.getRole())){
            users.setRole(Role.ADMIN);
        }else{
            users.setRole(Role.USER);
        }
        userDetailsRepository.save(users);
        return "Successfully saved";
    }
}
