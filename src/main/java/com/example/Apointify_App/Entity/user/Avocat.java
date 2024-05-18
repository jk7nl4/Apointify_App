package com.example.Apointify_App.Entity.user;

import jakarta.persistence.*;

@Entity
@Table(name="Avocats")
public class Avocat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String city;

    public Avocat() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    private boolean acceptedByAdmin;
    public Avocat(String address) {
        // Default constructor required by JPA
    }
    // Constructors, getters, and setters
    public Avocat(String address, String city) {
        this.address = address;
        this.city = city;
    }

    public Avocat(String name, String email, String password, String address, String city, boolean acceptedByAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.acceptedByAdmin = acceptedByAdmin;
    }
    @OneToOne
    @JoinColumn(name = "utilisateur_id" )
    private Utilisateur utilisateur;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAcceptedByAdmin() {
        return acceptedByAdmin;
    }

    public void setAcceptedByAdmin(boolean acceptedByAdmin) {
        this.acceptedByAdmin = acceptedByAdmin;
    }
}



