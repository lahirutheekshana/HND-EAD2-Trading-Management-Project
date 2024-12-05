package com.trading.user.service;

import com.trading.user.data.User;
import com.trading.user.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> getUserBid (int email) {
        return userRepository.findById(email);
    }

    public Optional<User> getUserByEmailPassword(String email, String password) {
        return userRepository.getUserByEmailPassword(email, password);
    }

    public User createUser(User user) {
       return userRepository.save(user);
    }

    public Optional<User> getUserIdByEmail(String email) {
        return userRepository.getUserIdByEmail(email);
    }

}
