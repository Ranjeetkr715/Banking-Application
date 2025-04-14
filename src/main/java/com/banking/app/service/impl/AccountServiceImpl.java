package com.banking.app.service.impl;

import com.banking.app.dto.AccountDto;
import com.banking.app.entity.Account;
import com.banking.app.exception.AccountException;
import com.banking.app.mapper.AccountMapper;
import com.banking.app.repository.AccountRepository;
import com.banking.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public AccountDto addAccount(AccountDto accountdto) {
        Account account = AccountMapper.mapToAccount(accountdto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account_detail = accountRepository.findById(id)
                .orElseThrow(() -> new AccountException("Account does not exist"));
        AccountDto accountDto_details = AccountMapper.mapToAccountDto(account_detail);
        return accountDto_details;
    }

    @Override
    public List<AccountDto> getAccounts() {
        List<AccountDto> allAccountDtoList = new ArrayList<>();
        List<Account> allAccountList = accountRepository.findAll();
        for(Account account :allAccountList){
            AccountDto accountDto = AccountMapper.mapToAccountDto(account);
            allAccountDtoList.add(accountDto);
        }
        return allAccountDtoList;
    }

    @Override
    public AccountDto depositBalance(Long id , Double amount) {
        Account depositeAccount = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exists"));
        double addedSalary =  depositeAccount.getSalary()+amount;
        depositeAccount.setSalary(addedSalary);
        accountRepository.save(depositeAccount);
        return AccountMapper.mapToAccountDto(depositeAccount);
    }

    @Override
    public AccountDto creditBalance(Long id , Double amount) {
        Account creaditAccount = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exists"));
        if(creaditAccount.getSalary() <= amount){
            throw  new AccountException("Insufficient balance for withdraw");
        }
        double addedSalary =  creaditAccount.getSalary() - amount;
        creaditAccount.setSalary(addedSalary);
        accountRepository.save(creaditAccount);
        return AccountMapper.mapToAccountDto(creaditAccount);
    }


    @Override
    public void updateAccount(Long id , AccountDto accountDto) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exists"));
         account.setAccount_holder_name(accountDto.getAccount_holder_name());
         account.setSalary(accountDto.getSalary());
         accountRepository.save(account);
    }

    @Override
    public void deleteAccountByID(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exists"));
        accountRepository.delete(account);
    }
}
