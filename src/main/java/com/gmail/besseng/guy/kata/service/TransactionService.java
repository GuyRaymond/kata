package com.gmail.besseng.guy.kata.service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.besseng.guy.kata.model.Account;
import com.gmail.besseng.guy.kata.model.Transaction;
import com.gmail.besseng.guy.kata.repository.AccountRepository;
import com.gmail.besseng.guy.kata.repository.TransactionRepository;
import com.gmail.besseng.guy.kata.exception.TransactionException;

@Transactional
@Component
@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction deposit(BigDecimal amount, Long idAccount) throws TransactionException{
        Account account = accountRepository.getOne(idAccount);
        Transaction transaction = new Transaction(amount, true);
        account.addTransaction(transaction);
        return transactionRepository.save(transaction);
    }
    public Transaction withdrawal(BigDecimal amount, Long idAccount) throws TransactionException {
        Account account = accountRepository.getOne(idAccount);
        Transaction transaction = new Transaction(amount, false);
        account.addTransaction(transaction);
        return transactionRepository.save(transaction);
    }
}
