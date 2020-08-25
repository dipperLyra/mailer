package com.shiftmonitor.mailer.controllers;

import com.shiftmonitor.mailer.dto.EmailRequest;
import com.shiftmonitor.mailer.services.MailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mailer")
public class MailerController {

    @Autowired
    MailManager mailManager;

    @PostMapping("/")
    String sendMail(@RequestBody EmailRequest emailRequest) {
        try {
            mailManager.post(
                    emailRequest.getFromEmail(),
                    emailRequest.getToEmail(),
                    emailRequest.getSendName(),
                    emailRequest.getSubject(),
                    emailRequest.getContentBody()
            );
        } catch (MailAuthenticationException e) {
            e.printStackTrace();
        }
        return "Mail sent successfully";
    }

    @GetMapping("/")
    String mailerServiceUp() {
        return "mailer service is up and running!";
    }
}