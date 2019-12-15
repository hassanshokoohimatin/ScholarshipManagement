package ir.maktab32.java.projects.scholarshipmanagement.model;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Entity;
import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String role;

    public User(Long id, String userName, String passWord, String role) {
        this.id = id;
        this.username = userName;
        this.password = passWord;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", passWord='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
