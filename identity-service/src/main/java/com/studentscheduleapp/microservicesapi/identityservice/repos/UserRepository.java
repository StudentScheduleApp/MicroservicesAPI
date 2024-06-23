package com.studentscheduleapp.microservicesapi.identityservice.repos;

import com.studentscheduleapp.microservicesapi.identityservice.models.User;
import com.studentscheduleapp.microservicesapi.identityservice.properties.services.DatabaseServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UserRepository {


    @Autowired
    private DatabaseServiceProperties databaseServiceProperties;

    @Autowired
    private RestTemplate restTemplate;

    public User getById(long id) throws Exception {
        ResponseEntity<User> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getGetUserByIdPath() + "/" + id, User.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public User getByEmail(String email) throws Exception {
        ResponseEntity<User> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getGetUserByEmailPath() + "/" + email, User.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public User save(User user) throws Exception {
        ResponseEntity<User> r = restTemplate.postForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getSaveUserPath(), user, User.class);
        if (r.getStatusCode().is2xxSuccessful())
            return r.getBody();
        throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }

    public void delete(long id) throws Exception {
        ResponseEntity<Void> r = restTemplate.getForEntity(databaseServiceProperties.getUri() + databaseServiceProperties.getDeleteUserPath() + "/" + id, Void.class);
        if (!r.getStatusCode().is2xxSuccessful())
            throw new Exception("request to " + databaseServiceProperties.getUri() + " return code " + r.getStatusCode());
    }
}
