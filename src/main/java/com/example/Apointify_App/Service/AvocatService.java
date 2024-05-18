package com.example.Apointify_App.Service;

import com.example.Apointify_App.Dto.AvocatDTO;
import com.example.Apointify_App.Entity.user.Avocat;
import com.example.Apointify_App.Repo.AvocatRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvocatService {
    private final AvocatRepository avocatRepository;
    private String address;

    @Autowired
    public AvocatService(AvocatRepository avocatRepository) {
        this.avocatRepository = avocatRepository;
    }

    public List<AvocatDTO> getAllAvocats() {
        return avocatRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AvocatDTO getAvocatById(Integer id) {
        Avocat avocat = avocatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Avocat Id:" + id));
        return convertToDTO(avocat);
    }

    public AvocatDTO createAvocat(AvocatDTO avocatDTO) {
        Avocat avocat = convertToEntity(avocatDTO);
        Avocat savedAvocat = avocatRepository.save(avocat);
        return convertToDTO(savedAvocat);
    }

    private AvocatDTO convertToDTO(Avocat avocat) {
        AvocatDTO avocatDTO = new AvocatDTO();
        BeanUtils.copyProperties(avocat, avocatDTO);
        return avocatDTO;
    }

    private Avocat convertToEntity(AvocatDTO avocatDTO) {
        Avocat avocat = new Avocat(address);
        BeanUtils.copyProperties(avocatDTO, avocat);
        return avocat;
    }


    public List<Avocat> getAvocatsByCity(String city) {
        return avocatRepository.findByCity(city);
    }
}
