package com.example.Apointify_App.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Apointify_App.Dto.AvocatDTO;
import com.example.Apointify_App.Entity.user.Avocat;
import com.example.Apointify_App.Service.AvocatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AvocatController {
    private final AvocatService avocatService;

    @Autowired
    public AvocatController(AvocatService avocatService) {
        this.avocatService = avocatService;
    }

    @GetMapping("/Lawyers")
    public String getAllAvocats(Model model) {
        List<AvocatDTO> avocats = avocatService.getAllAvocats();
        model.addAttribute("avocats", avocats);
        return "Lawyers"; //
    }


    @GetMapping("/{id}")
    public AvocatDTO getAvocatById(@PathVariable Integer id) {
        return avocatService.getAvocatById(id);
    }

    @PostMapping("/avocats") // Use a specific path for creating avocats
    public AvocatDTO createAvocat(@RequestBody AvocatDTO avocatDTO) {
        return avocatService.createAvocat(avocatDTO);
    }

    @GetMapping("/search")
    public String searchAvocats(@RequestParam("city") String city, Model model) {
        List<Avocat> avocats = avocatService.getAvocatsByCity(city);
        if (avocats.isEmpty()) {
            System.out.println("No avocats found for city: " + city);
        }
        model.addAttribute("avocats", avocats);
        return "Lawyers"; // Thymeleaf template name
    }
}
