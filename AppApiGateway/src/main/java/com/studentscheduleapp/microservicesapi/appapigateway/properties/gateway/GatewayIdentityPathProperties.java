package com.studentscheduleapp.microservicesapi.appapigateway.properties.gateway;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GatewayIdentityPathProperties {
    @Value("${gateway.identity.path.registerPath}")
    private String registerPath;
    @Value("${gateway.identity.path.verifyPath}")
    private String verifyPath;
    @Value("${gateway.identity.path.loginPath}")
    private String loginPath;
    @Value("${gateway.identity.path.refreshPath}")
    private String refreshPath;
    @Value("${gateway.identity.path.getUserIdByTokenPath}")
    private String getUserIdByTokenPath;
}
