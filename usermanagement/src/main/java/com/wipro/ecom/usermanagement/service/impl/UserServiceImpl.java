package com.wipro.ecom.usermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.ecom.usermanagement.entity.User;
import com.wipro.ecom.usermanagement.repo.UserRepository;
import com.wipro.ecom.usermanagement.security.JwtUtil;
import com.wipro.ecom.usermanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User register(User user) {
        return repo.save(user);
    }

    @Override
    public String login(String userId, String password) {
        User user = repo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getPassWord().equals(password)) {
            user.setLoggedIn(true);
            repo.save(user);
            return jwtUtil.generateToken(userId);
        }
        throw new RuntimeException("Invalid password");
    }

    @Override
    public String logout(int userId) {
        User user = repo.findById(userId).orElseThrow();
        user.setLoggedIn(false);
        repo.save(user);
        return "Logout successful";
    }

    @Override
    public User update(User user) {
        return repo.save(user);
    }

    @Override
    public void delete(int userId) {
        repo.deleteById(userId);
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getById(int id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public String getMenu(int id) {
        User user = getById(id);
        return user.getUserType() == 0 ? "Admin Dashboard" : "Customer Dashboard";
    }
}
