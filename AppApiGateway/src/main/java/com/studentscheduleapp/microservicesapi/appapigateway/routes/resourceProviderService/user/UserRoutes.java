package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.user;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
//@NoArgsConstructor
@Getter
public class UserRoutes {
    @Autowired
    private GetUserByIdRoute getUserByIdRoute;
    @Autowired
    private EditUserRoute editUserRoute;
}
