package com.sda.springhrapp.repository;

import com.sda.springhrapp.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepositoryIF extends CrudRepository<Account, Integer> {
    Integer deleteAccountById(Integer id);
    List<Account> findAll();
}
