package com.example.Apointify_App.Dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {
    @Getter
    private String name;
    @Getter
    private String email;
    @Getter
    private String phone;
    @Getter
    private Long lawyerId;
    @Getter
    private LocalDate date;
    @Getter
    private LocalTime time;
    @Getter
    private String title;
    @Getter
    private String description;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLawyerId(Long lawyerId) {
        this.lawyerId = lawyerId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setTitle(String title) {
    }

    public void setDescription(String description) {
    }

}
