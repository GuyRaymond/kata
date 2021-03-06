package com.gmail.besseng.guy.kata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gmail.besseng.guy.kata.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
