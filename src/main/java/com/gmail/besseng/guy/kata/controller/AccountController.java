package com.gmail.besseng.guy.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmail.besseng.guy.kata.model.Account;
import com.gmail.besseng.guy.kata.service.AccountService;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @GetMapping("/historyForAccount/{id}")
    Account historyAccount(@PathVariable Long id) {
        return accountService.findAccountById(id);
    }

    @PostMapping("/createAccountForUser/{idUser}")
    Account createAccountForUser(@PathVariable Long idUser) {
        return accountService.saveAccount(idUser);
    }
}
