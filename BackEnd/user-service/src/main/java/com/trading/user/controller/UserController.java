package com.trading.user.controller;

import com.trading.user.data.User;
import com.trading.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
public class UserController {
   @Autowired
   UserService userService;

   @GetMapping(path = "usersz")
   public ResponseEntity<User> getUserByid (@RequestParam("id") int id) {
        Optional<User> user = userService.getUserBid(id);
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
   }

   // Help For Logging Users  ********
   @GetMapping(path = "users")
   public Optional<User> getUserByEmailPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
       return userService.getUserByEmailPassword(email, password);
   }

   //Help For Register Users
   @PostMapping(path = "users")
   public User createUser (@RequestBody User user) {
       return userService.createUser(user);
   }

   // Help For Other-Services to getUserIdByEmail
   @GetMapping(path = "usersx")
   public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email) {
       Optional<User> user= userService.getUserIdByEmail(email);
       return ResponseEntity.status(HttpStatus.OK).body(user.get());
   }
}
