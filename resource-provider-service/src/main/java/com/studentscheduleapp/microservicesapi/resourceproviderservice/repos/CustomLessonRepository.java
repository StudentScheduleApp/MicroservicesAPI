package com.studentscheduleapp.microservicesapi.resourceproviderservice.repos;

import com.studentscheduleapp.microservicesapi.resourceproviderservice.models.CustomLesson;
import com.studentscheduleapp.microservicesapi.resourceproviderservice.properties.services.DatabaseServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CustomLessonRepository {


    @Autowired
    private DatabaseServiceProperties databaseServiceProperties;

    @Autowired
    private RestTemplate restTemplate;

    public CustomLesson getById(long id) throws Exception {
        ResponseEntity<CustomLesson> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getGetCustomLessonByIdPath() + "/" + id, CustomLesson.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public List<CustomLesson> getByGroupId(long id) throws Exception {
        ResponseEntity<CustomLesson[]> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getGetCustomLessonByGroupIdPath() + "/" + id, CustomLesson[].class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody() == null ? null : new ArrayList<>(Arrays.asList(r.getBody()));
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public CustomLesson save(CustomLesson customLesson) throws Exception {
        ResponseEntity<CustomLesson> r = restTemplate.postForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getSaveCustomLessonPath(), customLesson, CustomLesson.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public void delete(long id) throws Exception {
        ResponseEntity<Void> r = restTemplate.exchange(databaseServiceProperties.getUri() + databaseServiceProperties.getDeleteCustomLessonPath() + "/" + id, HttpMethod.DELETE, null, Void.class);
        if (!r.getStatusCode().is2xxSuccessful())
            throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }
}
