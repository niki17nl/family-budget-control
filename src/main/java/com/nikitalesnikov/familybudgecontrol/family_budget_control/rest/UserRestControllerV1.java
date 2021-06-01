package com.nikitalesnikov.familybudgecontrol.family_budget_control.rest;

import com.nikitalesnikov.familybudgecontrol.family_budget_control.dto.UserDto;
import com.nikitalesnikov.familybudgecontrol.family_budget_control.model.User;
import com.nikitalesnikov.familybudgecontrol.family_budget_control.repository.UserRepository;
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
 * REST controller user connected request.
 */

@RestController
@RequestMapping(value = "/api/v1/users/")
public class UserRestControllerV1 {
    private final UserService userService;

    @Autowired
    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/allusers")
    public List<User> getAll() {
        List<User> result = userService.getAll();
        return result;
    }
}