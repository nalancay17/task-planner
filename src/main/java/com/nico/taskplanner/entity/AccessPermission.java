package com.nico.taskplanner.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "access_permission")
public class AccessPermission {

    @Id
    @Column(name = "name", unique = true)
    @NotNull(message = "{validation.accessPermission.name.null}")
    @Size(min = 3, max = 30, message = "{validation.accessPermission.name.size}")
    private String name;

    @ManyToMany(mappedBy = "accessPermissions",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @NotNull(message = "{validation.accessPermission.users.null}")
    private Set<User> users = new HashSet<>();

    public AccessPermission() {

    }

    public AccessPermission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessPermission that = (AccessPermission) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "AccessPermission{" +
                "name='" + name + '\'' +
                '}';
    }

}
