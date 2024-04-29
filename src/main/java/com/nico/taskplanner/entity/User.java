package com.nico.taskplanner.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @NotNull(message = "{validation.user.id.null}")
    @PositiveOrZero(message = "{validation.user.id.positiveOrZero}")
    private long id;

    @Column(name = "name")
    @NotNull(message = "{validation.user.name.null}")
    @Size(min = 2, max = 40, message = "{validation.user.name.size}")
    private String name;

    @Column(name = "surname")
    @NotNull(message = "{validation.user.surname.null}")
    @Size(min = 2, max = 40, message = "{validation.user.surname.size}")
    private String surname;

    @Column(name = "email", unique = true)
    @NotNull(message = "{validation.user.email.null}")
    @Email(message = "{validation.user.email.email}")
    private String email;

    @Column(name = "username", unique = true)
    @NotNull(message = "{validation.user.username.null}")
    @Size(min = 4, max = 20, message = "{validation.user.username.size}")
    private String username;

    @Column(name = "password")
    @NotNull(message = "{validation.user.password.null}")
    @Size(min = 60, max = 255, message = "{validation.user.password.size}")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_access_permission",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "access_permission_name")}
    )
    @NotNull(message = "{validation.user.accessPermissions.null}")
    private Set<AccessPermission> accessPermissions = new HashSet<>();

    @Column(name = "registrationDate")
    @NotNull(message = "{validation.user.registrationDate.null}")
    @PastOrPresent(message = "{validation.user.registrationDate.pastOrPresent}")
    private Timestamp registrationDate;

    @Column(name = "enabled")
    private boolean enabled;


    public User() {

    }

    public User(long id, String name, String surname, String email, String username, String password,
                Timestamp registrationDate, boolean enabled) {
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

    public Set<AccessPermission> getAccessPermissions() {
        return accessPermissions;
    }

    public void setAccessPermissions(Set<AccessPermission> accessPermissions) {
        this.accessPermissions = accessPermissions;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accessPermissions=" + accessPermissions +
                ", registrationDate=" + registrationDate +
                ", enabled=" + enabled +
                '}';
    }
}
