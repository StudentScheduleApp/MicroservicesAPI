package com.studentscheduleapp.microservicesapi.identityservice.services;

import com.studentscheduleapp.microservicesapi.identityservice.models.api.SendMailRequest;
import com.studentscheduleapp.microservicesapi.identityservice.models.api.VerifyEmailRequest;
import com.studentscheduleapp.microservicesapi.identityservice.repos.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerifyEmailService {


    private final Map<String, Long> emailCodes = new HashMap<>();

    @Autowired
    private MailRepository mailRepository;


    public void sendCode(String email) throws Exception {
        long code;
        do {
            code = Math.round(Math.random() * 100000);
        } while (String.valueOf(code).length() != 5);

        mailRepository.send(new SendMailRequest(email, "Verify email", "code: " + code));
        emailCodes.put(email, code);
    }

    public boolean verify(VerifyEmailRequest verifyEmailRequest) {
        if (emailCodes.get(verifyEmailRequest.getEmail()) != null && emailCodes.get(verifyEmailRequest.getEmail()).equals(verifyEmailRequest.getCode())) {
            emailCodes.remove(verifyEmailRequest.getEmail());
            return true;
        }
        return false;
    }

}
