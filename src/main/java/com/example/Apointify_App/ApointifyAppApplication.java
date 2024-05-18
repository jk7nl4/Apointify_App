package com.example.Apointify_App;

import com.example.Apointify_App.Entity.user.Utilisateur;
import com.example.Apointify_App.Repo.UtilisateurRepo;
import com.example.Apointify_App.Entity.user.Avocat;
import com.example.Apointify_App.Repo.AvocatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ApointifyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApointifyAppApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(UtilisateurRepo UtilisateurRepo){
		return args -> {
			UtilisateurRepo.save(new Utilisateur(null,"Hassan@gmail.com","a123","hassan"));
			UtilisateurRepo.save(new Utilisateur(null,"Mohamed@gmail.com","b456","mohammed"));
			UtilisateurRepo.save(new Utilisateur(null,"Yassmine@gmail.com","c789","yassmine"));



		};
	}


}
