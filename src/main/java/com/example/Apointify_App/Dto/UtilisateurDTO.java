package com.example.Apointify_App.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UtilisateurDTO {
    private Integer id_utilisateur;
    private String email;
    private String pwd;
    private String nom;
}
