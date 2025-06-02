package com.wipro.ecom.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ecom.usermanagement.entity.User;
import com.wipro.ecom.usermanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.login(user.getUserId(), user.getPassWord());
    }

    @PostMapping("/logout")
    public String logout(@RequestParam int userId) {
        return service.logout(userId);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping
    public void delete(@RequestParam int userId) {
        service.delete(userId);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping("/menu/{id}")
    public String getMenu(@PathVariable int id) {
        return service.getMenu(id);
    }
}
