package com.gmail.guy.kata.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.guy.kata.model.Account;
import com.gmail.guy.kata.model.User;
import com.gmail.guy.kata.repository.AccountRepository;
import com.gmail.guy.kata.repository.UserRepository;

@Transactional
@Component
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public Account findAccountById(Long id) {
        return accountRepository.findById(id).get();
    }

    public Account saveAccount(Long idUser) {
        Account account = new Account();
        User user = userRepository.getOne(idUser);
        user.addAccount(account);
        return accountRepository.save(account);
    }
}
