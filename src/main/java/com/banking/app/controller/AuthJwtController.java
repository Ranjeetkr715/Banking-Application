package com.banking.app.controller;

import com.banking.app.payload.UserPayload;
import com.banking.app.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthJwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public String genrateToken(@RequestBody UserPayload userPayload) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userPayload.getUserName(), userPayload.getPassword())
            );
            return jwtUtil.genrateToken(userPayload.getUserName());
        } catch (Exception e) {
            System.out.println("Bad crendential");
            throw e;
        }
    }

}
