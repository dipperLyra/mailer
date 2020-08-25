package com.shiftmonitor.mailer.services.impl;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGridAPI;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.shiftmonitor.mailer.services.MailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MailManagerImpl implements MailManager {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SendGridAPI sendGridAPI;

    /*
    "contact@seamlezsales.com"
    "Eche"
     */
    public void post(String fromEmail, String toEmail, String sendName, String subject, String contentBody) {
        Email from = new Email(fromEmail, sendName);
        Email to = new Email(toEmail);
        Content content = new Content("text/plain", contentBody);
        Mail mail = new Mail(from, subject, to, content);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGridAPI.api(request);
            System.out.println(response.getBody());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
