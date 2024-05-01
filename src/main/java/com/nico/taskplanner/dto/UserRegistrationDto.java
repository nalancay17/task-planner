package com.nico.taskplanner.dto;

import jakarta.validation.constraints.*;

public class UserRegistrationDto {

    @NotNull(message = "{validation.user.name.null}")
    @Size(min = 2, max = 40, message = "{validation.user.name.size}")
    private String name;

    @NotNull(message = "{validation.user.surname.null}")
    @Size(min = 2, max = 40, message = "{validation.user.surname.size}")
    private String surname;

    @NotNull(message = "{validation.user.email.null}")
    @Email(message = "{validation.user.email.email}")
    private String email;

    @NotNull(message = "{validation.user.username.null}")
    @Size(min = 4, max = 20, message = "{validation.user.username.size}")
    private String username;

    @NotNull(message = "{validation.user.password.null}")
    @Size(min = 60, max = 255, message = "{validation.user.password.size}")
    private String password;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String name, String surname, String email, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
