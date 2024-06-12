package com.example.bankingapp.service;

import com.example.bankingapp.entity.Account;
import com.example.bankingapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(Long id, double amount) {
        return accountRepository.findById(id);
    }

    public Account deposit(Long id,double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
