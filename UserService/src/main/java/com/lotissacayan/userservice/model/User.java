package com.lotissacayan.userservice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String email;
    private String password;





    @Enumerated(EnumType.STRING)
    private Role role;


    @Enumerated(EnumType.STRING)
    private UserType userType;


    public User() {}


    public User(Long id, String name, String email, String password, Role role, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.userType = userType;
    }


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }

    public void setPassword( String password){
        this.password = password;
    }

    public Role getRole(){
        return role;
    }

    public void setRole( Role role){
    this.role = role;}


    public UserType getUserType(){
        return userType;
    }
    public void setUserType(UserType userType ){
        this.userType = userType;
    }

}