package com.example.bankingapp.controller;

import com.example.bankingapp.entity.Account;
import com.example.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(()-> new RuntimeException("Account not found"));
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String,Double> request) {
        Double amount = request.get("amount");
        return accountService.deposit(id,amount);
    }

    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request) {

    }
}
