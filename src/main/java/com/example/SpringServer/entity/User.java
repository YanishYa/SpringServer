package com.example.SpringServer.entity;

import jakarta.persistence.*;

@Entity
@Table(name="appDB.user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    private String login;
    private String password;
    public User(String login, String password, int yearBirth, String email){
        this.login = login;
        this.password = password;
    }
    public User(String login, String password){
        this.password = password;
        this.login = login;
    }
    public User(){
        login = "";
        password = "";
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return this.login;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
}

