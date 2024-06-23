package com.studentscheduleapp.microservicesapi.appapigateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "global")
@Component
public class GlobalProperties {
    private String serviceToken;
    private String serviceTokenHeader;
}
