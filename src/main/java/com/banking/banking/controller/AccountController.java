package com.banking.banking.controller;


import com.banking.banking.dto.AccountDto;
import com.banking.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Add Account Rest API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Account Rest API
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // Deposit Rest API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw Rest API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    // Get All Accounts Rest API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Delete Account Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Account is deleted successfully!");
        return ResponseEntity.ok(response);
    }

    // Delete Accounts within Given Range Rest API
    @DeleteMapping("/deleteRange/{minValue}/{maxValue}")
    public ResponseEntity<Map<String, String>> deleteAccountsInRange(@PathVariable Long minValue, @PathVariable Long maxValue){
        accountService.deleteAccountsInRange(minValue, maxValue);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Accounts deleted within range" + " " + minValue + " " + "to" + " " + maxValue);
        return ResponseEntity.ok(response);
    }
}
