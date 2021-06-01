package com.nikitalesnikov.familybudgecontrol.family_budget_control.rest;

import com.nikitalesnikov.familybudgecontrol.family_budget_control.dto.AdminUserDto;
import com.nikitalesnikov.familybudgecontrol.family_budget_control.dto.GlobalAdminDto;
import com.nikitalesnikov.familybudgecontrol.family_budget_control.model.User;
import com.nikitalesnikov.familybudgecontrol.family_budget_control.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for GLOBAL_ROLE_ADMIN requests.
 */

@RestController
@RequestMapping(value = "/api/v1/globaladmin/")
public class GlobalAdminRestControllerV1 {

    private final UserService userService;

    @Autowired
    public GlobalAdminRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<GlobalAdminDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        GlobalAdminDto result = GlobalAdminDto.fromAdmin(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/allusers")
    public List<User> getAll() {
        List<User> result = userService.getAll();
        return result;
    }
}
