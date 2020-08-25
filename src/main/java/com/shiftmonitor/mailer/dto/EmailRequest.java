package com.shiftmonitor.mailer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailRequest {
    private String fromEmail;
    private String toEmail;
    private String sendName;
    private String subject;
    private String contentBody;

}
