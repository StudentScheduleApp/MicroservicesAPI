package com.studentscheduleapp.microservicesapi.identityservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outline {
    private long id;
    private long userId;
    private long specificLessonId;

}
