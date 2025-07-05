package com.banking.app.service;

import com.banking.app.dto.AccountDto;
import com.banking.app.entity.Account;

import java.util.List;

public interface AccountService {

    AccountDto addAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    List<AccountDto> getAccounts();

    AccountDto depositBalance(Long id , Double amount);

    AccountDto creditBalance(Long id , Double amount);

    public AccountDto  updateAccount(Long id , AccountDto accountDto);

    public void deleteAccountByID(Long id);


}
