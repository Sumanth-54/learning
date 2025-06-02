package com.wipro.ecom.usermanagement.service;

import java.util.List;

import com.wipro.ecom.usermanagement.entity.User;

public interface UserService {
    User register(User user);
    String login(String userId, String password);
    String logout(int userId);
    User update(User user);
    void delete(int userId);
    List<User> getAll();
    User getById(int id);
    String getMenu(int id);
}
