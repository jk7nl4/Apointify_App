package com.example.Apointify_App.Controller;

import com.example.Apointify_App.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/sendNotification")
    public String sendNotification(@RequestBody String message, @RequestBody String email) {
        notificationService.sendNotification(message, email);
        return "Notification sent successfully";
    }
}
