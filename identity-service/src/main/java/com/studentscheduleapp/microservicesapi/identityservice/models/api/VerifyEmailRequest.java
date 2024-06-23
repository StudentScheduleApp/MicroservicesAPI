package com.studentscheduleapp.microservicesapi.identityservice.models.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyEmailRequest {

    private String email;
    private long code;

}
