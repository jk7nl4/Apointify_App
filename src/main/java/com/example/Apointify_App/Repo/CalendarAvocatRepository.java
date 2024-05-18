package com.example.Apointify_App.Repo;
import com.example.Apointify_App.Entity.CalendarAvocat;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CalendarAvocatRepository extends JpaRepository<CalendarAvocat, Integer> {
    // Add custom query methods if needed
}