package com.shiftmonitor.mailer.services;

public interface MailManager {
    void post(String fromEmail, String toEmail, String name, String subject, String contentBody);
    //void sendEmail(String email, String subject, String text);
}
