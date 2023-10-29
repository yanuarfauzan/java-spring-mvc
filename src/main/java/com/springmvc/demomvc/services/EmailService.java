package com.springmvc.demomvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;

    public void sendEmail(String to, String subject, String messages){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(messages);
        message.setFrom("fauzanisnain017@gmail.com");
        // pakai sender
        sender.send(message);
    }
}
