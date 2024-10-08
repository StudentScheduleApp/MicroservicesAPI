package com.studentscheduleapp.microservicesapi.identityservice.repos;

import com.studentscheduleapp.microservicesapi.identityservice.models.LessonTemplate;
import com.studentscheduleapp.microservicesapi.identityservice.properties.services.DatabaseServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class LessonTemplateRepository {


    @Autowired
    private DatabaseServiceProperties databaseServiceProperties;

    @Autowired
    private RestTemplate restTemplate;

    public LessonTemplate getById(long id) throws Exception {
        ResponseEntity<LessonTemplate> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getGetLessonTemplateByIdPath() + "/" + id, LessonTemplate.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public List<LessonTemplate> getByScheduleTemplateId(long id) throws Exception {
        ResponseEntity<LessonTemplate[]> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getGetLessonTemplateByScheduleTemplateIdPath() + "/" + id, LessonTemplate[].class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody() == null ? null : new ArrayList<>(Arrays.asList(r.getBody()));
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public LessonTemplate save(LessonTemplate lessonTemplate) throws Exception {
        ResponseEntity<LessonTemplate> r = restTemplate.postForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getSaveLessonTemplatePath(), lessonTemplate, LessonTemplate.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public void delete(long id) throws Exception {
        ResponseEntity<Void> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getDeleteLessonTemplatePath() + "/" + id, Void.class);
        if (!r.getStatusCode().is2xxSuccessful())
            throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }
}
