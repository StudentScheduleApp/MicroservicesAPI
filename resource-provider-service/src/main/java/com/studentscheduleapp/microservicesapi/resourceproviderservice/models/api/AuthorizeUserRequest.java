package com.studentscheduleapp.microservicesapi.resourceproviderservice.models.api;

import com.studentscheduleapp.microservicesapi.resourceproviderservice.models.AuthorizeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizeUserRequest {

    private String userToken;
    private AuthorizeEntity authorizeEntity;

}
