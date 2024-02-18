package com.example.service;

import com.example.exceptions.AccountException;
import com.example.models.Account;
import com.example.repo.AccountRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;

@ApplicationScoped
public class AccountService {

    @Inject
    AccountRepo accountRepo;

    public Account findAccountById(String id) {
        return accountRepo.find("accountNumber = ?1", id).firstResult();
    }

    public BigDecimal findBalanceById(String id) throws AccountException {
        Account account = findAccountById(id);
        if (account == null) {
            throw new AccountException("No account found for account number: " + id);
        }
        return account.getBalance();
    }

    @Transactional
    public Account createAccount(Account account) throws AccountException {
        if (account == null)
            throw new AccountException("Invalid data");

        Account existingAccount = findAccountById(account.getAccountNumber());

        if (existingAccount != null) {
            throw new AccountException("An account with the same account number already exists");
        }
        accountRepo.persist(account);
        return account;
    }

    @Transactional
    public BigDecimal deposit(String accountNumber, BigDecimal amount) throws AccountException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new AccountException("Amount must be of a positive value");

        Account account = findAccountById(accountNumber);

        if (account == null)
            throw new AccountException("Account does not exist.");

        account.setBalance(account.getBalance().add(amount));
        accountRepo.persist(account);

        return account.getBalance();
    }
}
