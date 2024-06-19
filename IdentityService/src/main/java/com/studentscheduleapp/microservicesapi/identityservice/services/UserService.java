package com.studentscheduleapp.microservicesapi.identityservice.services;


import com.studentscheduleapp.microservicesapi.identityservice.models.User;
import com.studentscheduleapp.microservicesapi.identityservice.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getByEmail(String email) throws Exception {
        return userRepository.getByEmail(email);
    }

    public User getById(long id) throws Exception {
        return userRepository.getById(id);
    }

    public User create(User user) throws Exception {
        return userRepository.save(user);
    }

}