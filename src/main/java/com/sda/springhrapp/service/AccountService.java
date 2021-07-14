package com.sda.springhrapp.service;

import com.sda.springhrapp.model.Account;
import com.sda.springhrapp.repository.AccountRepositoryIF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepositoryIF accountRepositoryIF;

    public Account saveAccount(Account account){
        accountRepositoryIF.save(account);
        log.info("Account saved successfully!");
        return account;
    }

    public Integer deleteAccountById(Integer id){
        Integer account = accountRepositoryIF.deleteAccountById(id);
        if (account !=0){
            log.info("Account with ID" + id + "was deleted!");
        } else {
            log.warn("The account didn't get deleted!");
        }
        return account;
    }

    public List<Account> findAllAccounts(){
        return accountRepositoryIF.findAll();
    }
}
