package com.example.Apointify_App.Entity;

import com.example.Apointify_App.Entity.user.Avocat;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="CalendarEvent")
public class CalendarAvocat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_event")
    private Integer id_event;

    @ManyToOne
    @JoinColumn(name="id_avocat")
    private Avocat avocat;

    @Column(name="date")
    private Date date;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    public CalendarAvocat(Avocat avocat, Date date, String title, String description) {
        this.avocat = avocat;
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public CalendarAvocat() {
    }

    public Integer getId_event() {
        return id_event;
    }

    public void setId_event(Integer id_event) {
        this.id_event = id_event;
    }

    public Avocat getAvocat() {
        return avocat;
    }

    public void setAvocat(Avocat avocat) {
        this.avocat = avocat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
