package com.studentscheduleapp.microservicesapi.identityservice.config;

import com.studentscheduleapp.microservicesapi.identityservice.http.HeaderRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class ServiceConfig {


    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(headerRequestInterceptor()));
        return restTemplate;
    }

    @Bean
    public HeaderRequestInterceptor headerRequestInterceptor() {
        return new HeaderRequestInterceptor();
    }

}
