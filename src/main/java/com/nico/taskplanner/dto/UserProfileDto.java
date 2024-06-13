package com.nico.taskplanner.dto;

import jakarta.validation.constraints.*;

import java.sql.Timestamp;

public class UserProfileDto {

    @NotNull(message = "{validation.user.id.null}")
    @PositiveOrZero(message = "{validation.user.id.positiveOrZero}")
    private long id;

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

    @NotNull(message = "{validation.user.registrationDate.null}")
    @PastOrPresent(message = "{validation.user.registrationDate.pastOrPresent}")
    private Timestamp registrationDate;

    private boolean enabled;

    public UserProfileDto() {

    }

    public UserProfileDto(long id, String name, String surname, String email, String username, String password, Timestamp registrationDate, boolean enabled) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
