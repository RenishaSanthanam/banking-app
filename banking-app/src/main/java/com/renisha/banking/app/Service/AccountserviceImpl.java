package com.renisha.banking.app.Service;

import com.renisha.banking.app.Entity.Account;
import com.renisha.banking.app.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountserviceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountserviceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't Exixts"));
        return account;
    }

    @Override
    public Account depositAmount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not Exits"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        return accountRepository.save(account);
    }

    @Override
    public Account withdrawAmount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account doesn't Exists"));

        if(account.getBalance()<amount){
            throw new RuntimeException("Insuffienct Amount");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account doesn't exists"));

        accountRepository.deleteById(id);
    }
}
