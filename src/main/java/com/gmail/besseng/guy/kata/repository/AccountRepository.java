package com.gmail.besseng.guy.kata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gmail.besseng.guy.kata.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
