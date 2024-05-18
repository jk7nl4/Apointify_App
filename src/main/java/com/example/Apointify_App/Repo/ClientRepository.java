package com.example.Apointify_App.Repo;

import com.example.Apointify_App.Entity.user.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findById(Long id);
    // You can add custom query methods here if needed
}