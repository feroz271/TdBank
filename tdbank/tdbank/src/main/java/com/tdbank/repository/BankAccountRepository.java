package com.tdbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdbank.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
