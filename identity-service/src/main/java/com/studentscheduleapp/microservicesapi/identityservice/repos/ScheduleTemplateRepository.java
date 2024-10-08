package com.studentscheduleapp.microservicesapi.identityservice.repos;

import com.studentscheduleapp.microservicesapi.identityservice.models.ScheduleTemplate;
import com.studentscheduleapp.microservicesapi.identityservice.properties.services.DatabaseServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ScheduleTemplateRepository {


    @Autowired
    private DatabaseServiceProperties databaseServiceProperties;

    @Autowired
    private RestTemplate restTemplate;

    public ScheduleTemplate getById(long id) throws Exception {
        ResponseEntity<ScheduleTemplate> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getGetScheduleTemplateByIdPath() + "/" + id, ScheduleTemplate.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public List<ScheduleTemplate> getByGroupId(long id) throws Exception {
        ResponseEntity<ScheduleTemplate[]> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getGetScheduleTemplateByGroupIdPath() + "/" + id, ScheduleTemplate[].class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody() == null ? null : new ArrayList<>(Arrays.asList(r.getBody()));
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public ScheduleTemplate save(ScheduleTemplate customLesson) throws Exception {
        ResponseEntity<ScheduleTemplate> r = restTemplate.postForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getSaveScheduleTemplatePath(), customLesson, ScheduleTemplate.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public void delete(long id) throws Exception {
        ResponseEntity<Void> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getDeleteScheduleTemplatePath() + "/" + id, Void.class);
        if (!r.getStatusCode().is2xxSuccessful())
            throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }
}
