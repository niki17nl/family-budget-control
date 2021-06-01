package com.nikitalesnikov.familybudgecontrol.family_budget_control.repository;

import com.nikitalesnikov.familybudgecontrol.family_budget_control.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface that extends JpaRepository for class  Role.
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}