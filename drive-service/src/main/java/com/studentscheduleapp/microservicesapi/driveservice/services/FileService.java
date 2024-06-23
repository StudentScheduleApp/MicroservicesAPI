package com.studentscheduleapp.microservicesapi.driveservice.services;

import com.studentscheduleapp.microservicesapi.driveservice.repos.GoogleDriveRepo;
import com.studentscheduleapp.microservicesapi.driveservice.repos.YandexDriveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    @Autowired
    private GoogleDriveRepo googleDriveRepo;
    @Autowired
    private YandexDriveRepo yandexDriveRepo;

    public String create(MultipartFile file) throws Exception {
        return yandexDriveRepo.create(file);
    }

    public void delete(String name) throws Exception {
        yandexDriveRepo.delete(name);
    }
}
