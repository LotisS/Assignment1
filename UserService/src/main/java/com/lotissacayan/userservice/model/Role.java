package com.lotissacayan.userservice.model;


import java.util.Optional;

public enum Role {

    STUDENT("student"),
    STAFF("staff"),
    TEACHER("teacher");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }


}
