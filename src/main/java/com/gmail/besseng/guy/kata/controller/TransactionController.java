package com.gmail.besseng.guy.kata.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gmail.besseng.guy.kata.model.Transaction;
import com.gmail.besseng.guy.kata.service.TransactionService;
import com.gmail.besseng.guy.kata.exception.TransactionException;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/depositForAccount/{idAccount}")
    Transaction depositForAccount(@RequestParam(required = true) BigDecimal amount, @PathVariable Long idAccount) throws TransactionException {
        return transactionService.deposit(amount, idAccount);
    }

    @PostMapping("/withdrawalForAccount/{idAccount}")
    Transaction withdrawalForAccount(@RequestParam(required = true) BigDecimal amount, @PathVariable Long idAccount) throws TransactionException {
        return transactionService.withdrawal(amount, idAccount);
    }
}
