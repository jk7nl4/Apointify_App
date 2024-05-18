package com.example.Apointify_App.Service;

import com.example.Apointify_App.Entity.Notification;
import com.example.Apointify_App.Repo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
    void sendNotification(String message, String email);
}