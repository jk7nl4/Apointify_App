package com.example.Apointify_App.Service;

import com.example.Apointify_App.Entity.user.Utilisateur;
import com.example.Apointify_App.Repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    private final UtilisateurRepo utilisateurRepo;

    @Autowired
    public UtilisateurService(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }

    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    public Utilisateur findByEmail(String email) {
        return utilisateurRepo.findByEmail(email);
    }

}
