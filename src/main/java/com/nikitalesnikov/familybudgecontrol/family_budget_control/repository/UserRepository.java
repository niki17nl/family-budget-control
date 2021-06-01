package com.nikitalesnikov.familybudgecontrol.family_budget_control.repository;

import com.nikitalesnikov.familybudgecontrol.family_budget_control.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface that extends JpaRepository for class User.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
