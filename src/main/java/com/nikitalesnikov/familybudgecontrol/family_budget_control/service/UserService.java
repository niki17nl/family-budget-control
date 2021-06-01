package com.nikitalesnikov.familybudgecontrol.family_budget_control.service;

import com.nikitalesnikov.familybudgecontrol.family_budget_control.model.User;

import java.util.List;

/**
 * Service interface for class User.
 */

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}