package com.studentscheduleapp.microservicesapi.appapigateway.routes.identityService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class IdentityServiceRoutes {
    @Autowired
    private RegisterRoute registerRoute;
    @Autowired
    private RefreshRoute refreshRoute;
    @Autowired
    private LoginRoute loginRoute;
    @Autowired
    private VerifyRoute verifyRoute;
    @Autowired
    private GetUserByTokenRoute getUserByTokenRoute;
}
