package com.renisha.banking.app.Service;

import com.renisha.banking.app.Entity.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);

    public Account getAccountById(Long id);

    public Account depositAmount(Long id, double amount);

    public Account withdrawAmount(Long id, double amount);

    public List<Account> getAllAccounts();

    public void deleteAccount(Long id);
}
