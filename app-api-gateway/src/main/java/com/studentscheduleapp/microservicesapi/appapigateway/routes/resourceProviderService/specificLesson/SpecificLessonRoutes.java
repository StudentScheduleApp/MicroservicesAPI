package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.specificLesson;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class SpecificLessonRoutes {
    @Autowired
    private GetSpecificLessonByIdRoute getSpecificLessonByIdRoute;
    @Autowired
    private GetSpecificLessonsByGroupIdRoute getSpecificLessonsByGroupIdRoute;
    @Autowired
    private CreateSpecificLessonRoute createSpecificLessonRoute;
    @Autowired
    private DeleteSpecificLessonRoute deleteSpecificLessonRoute;
    @Autowired
    private EditSpecificLessonRoute editSpecificLessonRoute;
}
