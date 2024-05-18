
package com.example.Apointify_App.Dto;

import lombok.Getter;

@Getter
public class AvocatDTO {

    // Getters and setters
    private Long id;
    private String name;
    private String email;
    private String password;
    private boolean acceptedByAdmin;


    public void setCity(String city) {
        this.city = city;
    }

    private String city;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAcceptedByAdmin(boolean acceptedByAdmin) {
        this.acceptedByAdmin = acceptedByAdmin;
    }
}
