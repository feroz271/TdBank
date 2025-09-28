package com.tdbank.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.tdbank.entity.BankAccount;
import com.tdbank.entity.Customer;
import com.tdbank.repository.BankAccountRepository;
import com.tdbank.repository.CustomerRepository;
import com.tdbank.exception.ResourceNotFoundException;

@Service
public class BankAccountService {

    private final BankAccountRepository accountRepo;
    private final CustomerRepository customerRepo;

    public BankAccountService(BankAccountRepository accountRepo, CustomerRepository customerRepo) {
        this.accountRepo = accountRepo;
        this.customerRepo = customerRepo;
    }

    public BankAccount createAccount(Long customerId, BankAccount account) {
        Customer customer = customerRepo.findById(customerId)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
        account.setCustomer(customer);
        return accountRepo.save(account);
    }

    public List<BankAccount> getAllAccounts() {
        return accountRepo.findAll();
    }

    public BankAccount getAccountById(Long id) {
        return accountRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
    }

    public BankAccount updateAccount(Long id, BankAccount newAccount) {
        BankAccount existing = getAccountById(id);
        existing.setAccountType(newAccount.getAccountType());
        existing.setBalance(newAccount.getBalance());
        return accountRepo.save(existing);
    }

    public void deleteAccount(Long id) {
        BankAccount existing = getAccountById(id);
        accountRepo.delete(existing);
    }
}
