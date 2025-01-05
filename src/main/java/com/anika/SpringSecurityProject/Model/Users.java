package com.anika.SpringSecurityProject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        username = userName;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", UserName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Users(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Users() {
    }
}
