package com.banking.app.mapper;

import com.banking.app.dto.AccountDto;
import com.banking.app.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountdto){
        Account account = new Account();
        account.setAccount_id(account.getAccount_id());
        account.setAccount_holder_name(accountdto.getAccount_holder_name());
        account.setSalary(accountdto.getSalary());
        return account;
    }

    //Using recored
//    public static Account mapToAccount(AccountDto accountdto){
//        Account account = new Account();
//        account.setAccount_id(accountdto.id());
//        account.setAccount_holder_name(accountdto.accountHolderName());
//        account.setSalary(accountdto.salary());
//        return account;
//    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto= new AccountDto();
         accountDto.setId(account.getAccount_id());
         accountDto.setAccount_holder_name(account.getAccount_holder_name());
         accountDto.setSalary(account.getSalary());
        return accountDto;
    }


//.   Record
//        public static AccountDto mapToAccountDto(Account account){
//        AccountDto accountDto= new AccountDto(account.getAccount_id(),account.getAccount_holder_name(),account.getSalary());
//        return accountDto;
//    }
}
