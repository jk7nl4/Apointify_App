package com.example.Apointify_App.Entity;

import com.example.Apointify_App.Entity.user.Avocat;
import com.example.Apointify_App.Entity.user.Client;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    public void setAvocat(Avocat avocat) {
        this.avocat = avocat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(LocalDate title) {
        this.title = String.valueOf(title);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "avocat_id", referencedColumnName = "id")
    private Avocat avocat;

    @Column(name = "date")
    private LocalDate date;
    @Column(name = "title")
    private String title;
    @Column(name = "name")
    private String name;
    @Column(name = "time")
    private LocalTime time;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "accepted")
    private Boolean accepted;
    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;
    public Appointment() {
    }

    public Appointment(Client client, Avocat avocat, LocalDate date, LocalTime time, Integer duration, Boolean accepted,String description,String title) {
        this.client = client;
        this.avocat = avocat;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.accepted = accepted;
        this.title= title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Avocat getAvocat() {
        return avocat;
    }

    public void setAvocat(String avocatDto) {

    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public void setEmail(String email) {
    }

    public void setPhone(String phone) {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
