package com.example.Apointify_App.Repo;

import com.example.Apointify_App.Entity.user.Avocat;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface AvocatRepository extends JpaRepository<Avocat, Integer> {



    List<Avocat> findByCity(String city);
}