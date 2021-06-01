package com.nikitalesnikov.familybudgecontrol.family_budget_control.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nikitalesnikov.familybudgecontrol.family_budget_control.model.Status;
import com.nikitalesnikov.familybudgecontrol.family_budget_control.model.User;
import lombok.Data;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

/**
 * DTO class for user requests by ROLE_ADMIN
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalAdminDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String balance;
    private String email;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBalance(balance);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getUsername());
        adminUserDto.setFirstName(user.getFirstName());
        adminUserDto.setLastName(user.getLastName());
        adminUserDto.setEmail(user.getEmail());
        adminUserDto.setStatus(user.getStatus().name());
        return adminUserDto;
    }
    public  static  GlobalAdminDto fromAdmin(User admin) {
        GlobalAdminDto globalAdminDto = new GlobalAdminDto();
        globalAdminDto.setId(admin.getId());
        globalAdminDto.setUsername(admin.getUsername());
        globalAdminDto.setFirstName(admin.getFirstName());
        globalAdminDto.setLastName(admin.getLastName());
        globalAdminDto.setEmail(admin.getEmail());
        globalAdminDto.setStatus(admin.getStatus().name());
    return globalAdminDto;
    }
}