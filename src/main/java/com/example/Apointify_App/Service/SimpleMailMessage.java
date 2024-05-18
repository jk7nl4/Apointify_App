package com.example.Apointify_App.Service;

import org.springframework.stereotype.Service;

@Service

public class SimpleMailMessage {
    private String[] to;
    private String subject;
    private String text;

    public void setTo(String email) {
        this.to = new String[]{email};
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
