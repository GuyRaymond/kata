package com.gmail.guy.kata.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gmail.guy.kata.model.User;
import com.gmail.guy.kata.repository.UserRepository;

@Transactional
@Component
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(User user, Long id) {
        User existUser = userRepository.findById(id).get();
        existUser.setName(user.getName());
        return userRepository.save(existUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
} 
