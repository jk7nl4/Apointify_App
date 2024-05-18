package com.example.Apointify_App.Entity.user;

import jakarta.persistence.*;

@Entity
@Table(name="Utilisateur")
public class Utilisateur {
    @Id
    @Column(name="id_utilisateur", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_utilisateur;


    @Column(name="email", length = 255)
    private String email;


    @Column(name="pwd", length = 255)
    private String pwd;


    @Column(name="nom", length = 255)
    private String nom;

    public Utilisateur(Integer id_utilisateur,String email,String pwd,String nom) {
        this.id_utilisateur=id_utilisateur;
        this.email=email;
        this.pwd=pwd;
        this.nom=nom;

    }

    public Utilisateur() {
    }
    @OneToOne(mappedBy = "utilisateur")
    private Avocat avocat;

    public void setId_utilisateur(Integer id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }





    public void setAvocat(Avocat avocat) {
        this.avocat = avocat;
    }


    public String getEmail() {
        return email;
    }

    public Object getPwd() {
        return pwd;
    }
}
