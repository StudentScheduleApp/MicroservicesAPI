package com.studentscheduleapp.microservicesapi.imageservice.repos;

import com.studentscheduleapp.microservicesapi.imageservice.properties.services.DriveServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class DriveRepo {

    @Autowired
    private DriveServiceProperties driveServiceProperties;

    @Autowired
    private RestTemplate restTemplate;

    public String create(MultipartFile file) throws Exception {
        Resource multipartFile = file.getResource();
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", multipartFile);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, null);
        ResponseEntity<String> r = restTemplate.postForEntity(driveServiceProperties.getUri() + driveServiceProperties.getUploadPath(), requestEntity, String.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + driveServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public void delete(String url) throws Exception {
        ResponseEntity<Void> r = restTemplate.exchange(driveServiceProperties.getUri() + driveServiceProperties.getDeletePath() + "?downloadUrl={url}", HttpMethod.DELETE, null, Void.class, url);
        if (!r.getStatusCode().is2xxSuccessful())
            throw new Exception("request to " + driveServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

}
