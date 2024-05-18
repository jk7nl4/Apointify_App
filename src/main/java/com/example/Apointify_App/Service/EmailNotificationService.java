package com.example.Apointify_App.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendNotification(String message, String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Appointment Notification");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}
