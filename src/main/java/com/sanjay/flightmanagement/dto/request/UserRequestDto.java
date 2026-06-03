package com.sanjay.flightmanagement.dto.request;

import com.sanjay.flightmanagement.entity.User;
import com.sanjay.flightmanagement.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserRequestDto {

    private String userName;

    @Column(unique = true)
    private String user_email;

    private String user_password;

    @Enumerated(EnumType.STRING)
    private Role role;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
