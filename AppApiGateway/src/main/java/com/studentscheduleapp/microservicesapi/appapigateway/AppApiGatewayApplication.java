package com.studentscheduleapp.microservicesapi.appapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class AppApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApiGatewayApplication.class, args);
    }

}
