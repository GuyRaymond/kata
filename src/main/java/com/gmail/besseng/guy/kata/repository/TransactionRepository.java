package com.gmail.besseng.guy.kata.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gmail.besseng.guy.kata.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
