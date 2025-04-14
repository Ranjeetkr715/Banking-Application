package com.banking.app.exception;

import com.banking.app.dto.AccountDto;

public class AccountException extends RuntimeException {

    public AccountException(String message){
        super(message);
    }
}
