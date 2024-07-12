package com.renisha.banking.app.Controller;

import com.renisha.banking.app.Entity.Account;
import com.renisha.banking.app.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}/deposit")
    public Account depositAmount(@PathVariable Long id, @RequestBody Map<String,Double> request){
        double amount = request.get("amount");
        return accountService.depositAmount(id,amount);
    }

    @PutMapping("/{id}/withdraw")
    public Account withdrawAmount(@PathVariable Long id,@RequestBody Map<String,Double> request){
        double amount = request.get("amount");
        return accountService.withdrawAmount(id,amount);
    }

    @GetMapping()
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @DeleteMapping("{id}/remove")
    public String deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return "Account removed successfully";
    }








}
