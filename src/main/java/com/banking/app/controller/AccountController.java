package com.banking.app.controller;

import com.banking.app.dto.AccountDto;
import com.banking.app.service.impl.AccountServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
@Tag(name = "Account Management", description = "Operations related to bank accounts")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('WEATHER_WRITE')")
    @Operation(summary = "Create an account", description = "Creates a new bank account")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        AccountDto addAccount = accountService.addAccount(accountDto);
        return new ResponseEntity<>(addAccount,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('WEATHER_READ')")
    @Operation(summary = "Get account details", description = "Fetch account details by ID")
    public ResponseEntity<AccountDto> getAccountDetailById(@PathVariable Long id){
        AccountDto accountById = accountService.getAccountById(id);
        return new ResponseEntity<>(accountById,HttpStatus.OK);
    }
    @GetMapping("/all")
    @Operation(summary = "Get all accounts", description = "Retrieve all bank accounts")
    public ResponseEntity<List<AccountDto>> getAllAccountDetails(){
        List<AccountDto> accountsDetails = accountService.getAccounts();
        return new ResponseEntity<>(accountsDetails,HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    @Operation(summary = "Deposit money", description = "Deposit money into an account")
    public ResponseEntity<AccountDto> depositSalary(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto addedAmount = accountService.depositBalance(id, amount);
        return new ResponseEntity<>(addedAmount,HttpStatus.OK);

    }

    @PutMapping("/{id}/credit")
    @Operation(summary = "Withdraw money", description = "Withdraw money from an account")
    public ResponseEntity<AccountDto> creditSalary(@PathVariable Long id,@RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        AccountDto restAmount = accountService.creditBalance(id, amount);
        return new ResponseEntity<>(restAmount,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update account", description = "Update account details by ID")
    public ResponseEntity<String> updateAccount(@PathVariable Long id,@RequestBody AccountDto accountDto){
        accountService.updateAccount(id, accountDto);
        return new ResponseEntity<>("Account has been updated Successfully",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('WEATHER_DELETE')")
    @Operation(summary = "Delete account", description = "Delete an account by ID")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
        accountService.deleteAccountByID(id);
        return new ResponseEntity<>("Account has been Successfully deleted",HttpStatus.OK);
    }


}
