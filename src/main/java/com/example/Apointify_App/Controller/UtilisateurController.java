package com.example.Apointify_App.Controller;

import com.example.Apointify_App.Entity.UserRole;
import com.example.Apointify_App.Entity.user.Utilisateur;
import com.example.Apointify_App.Repo.UtilisateurRepo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/Utilisateur")
@AllArgsConstructor
public class UtilisateurController {

//        @Autowired
//        private UtilisateurService UtilisateurService;
        private UtilisateurRepo UtilisateurRepo ;

    @Enumerated(EnumType.STRING)
    @Column(name="role", length = 45)
    private UserRole role;

        @PostMapping(path = "/Register")
        public Utilisateur saveUtilisateur(@RequestBody Utilisateur Utilisateur)
        {
//            String id = UtilisateurService.addUtilisateur(UtilisateurDTO);
//            return id;
            Utilisateur U = UtilisateurRepo.save(Utilisateur);
            return U;
        }
        @PostMapping(path = "/Auth")
        public Utilisateur Auth(@RequestBody Utilisateur Utilisateur)
        {
//            String id = UtilisateurService.addUtilisateur(UtilisateurDTO);
//            return id;
            Utilisateur U = UtilisateurRepo.findByEmail(Utilisateur.getEmail());
            if(U != null && Utilisateur.getPwd().equals(U.getPwd())){
                return U;
            }
            else {
                throw new IllegalArgumentException("Invalid email or password");
            }

        }

}
