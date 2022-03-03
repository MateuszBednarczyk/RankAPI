package com.example.rankapi.MailSender;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService{

    private JavaMailSender javaMailSender;

    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String directionMail, String mailSubject, String mailText) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(directionMail);
        msg.setSubject(mailSubject);
        msg.setText(mailText);

        javaMailSender.send(msg);
    }
}