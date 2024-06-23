package com.studentscheduleapp.microservicesapi.resourceproviderservice.services;

import org.springframework.stereotype.Service;

@Service
public class UrlService {

    public String getNameFromImageUrl(String url) {
        return url.substring(43, url.length() - 16);
    }

}
