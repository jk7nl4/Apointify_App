package com.example.Apointify_App.Entity;

import com.example.Apointify_App.Entity.user.Client;
import com.example.Apointify_App.Entity.user.Avocat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Notification")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "avocat_id", nullable = false)
    private Avocat avocat;

    @Column(name = "message")
    private String message;

    @Column(name = "created_at")
    private Date createdAt;

    public Notification(Client client, Avocat avocat, String message) {
        this.client = client;
        this.avocat = avocat;
        this.message = message;
        this.createdAt = new Date();
    }
}
