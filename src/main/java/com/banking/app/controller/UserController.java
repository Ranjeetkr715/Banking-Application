package com.banking.app.controller;


import com.banking.app.payload.UserCreatePayload;
import com.banking.app.payload.UserPayload;
import com.banking.app.service.impl.UserSavedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserSavedService userSavedService;

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserCreatePayload userCreatePayload){
        userSavedService.savedUser(userCreatePayload);
        return ResponseEntity.ok("Successfully saved");
    }
}
