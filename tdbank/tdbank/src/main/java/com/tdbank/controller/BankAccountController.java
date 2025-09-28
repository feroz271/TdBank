package com.tdbank.controller;

import com.tdbank.entity.BankAccount;
import com.tdbank.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @PostMapping("/{customerId}")
    public BankAccount create(@PathVariable Long customerId, @RequestBody BankAccount account) {
        return service.createAccount(customerId, account);
    }

    @GetMapping
    public List<BankAccount> getAll() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public BankAccount getById(@PathVariable Long id) {
        return service.getAccountById(id);
    }

    @PutMapping("/{id}")
    public BankAccount update(@PathVariable Long id, @RequestBody BankAccount account) {
        return service.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAccount(id);
    }
}
