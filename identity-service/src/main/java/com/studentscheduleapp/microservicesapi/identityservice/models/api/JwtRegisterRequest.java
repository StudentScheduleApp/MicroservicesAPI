package com.studentscheduleapp.microservicesapi.identityservice.models.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JwtRegisterRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

}