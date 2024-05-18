package com.example.Apointify_App.Repo;

import com.example.Apointify_App.Entity.user.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Integer> {
    Utilisateur findByEmail(String email);
}
