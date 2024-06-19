package com.studentscheduleapp.microservicesapi.driveservice.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GlobalProperties {
    @Value("${global.serviceToken}")
    private String serviceToken;
    @Value("${global.serviceTokenHeader}")
    private String serviceTokenHeader;
    @Value("${global.maxfilesize}")
    private long maxFileSize;

}
