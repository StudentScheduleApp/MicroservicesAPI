package com.studentscheduleapp.microservicesapi.identityservice.models.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private final String type = "Bearer";
    private long id;
    private String accessToken;
    private String refreshToken;
    private long accessTokenValidity;
    private long refreshTokenValidity;

}
