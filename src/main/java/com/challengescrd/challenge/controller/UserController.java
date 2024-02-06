package com.challengescrd.challenge.controller;

import com.challengescrd.challenge.entities.User;
import com.challengescrd.challenge.entities.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping
    public List<User> listing() {
        return userRepository.findAll();
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}