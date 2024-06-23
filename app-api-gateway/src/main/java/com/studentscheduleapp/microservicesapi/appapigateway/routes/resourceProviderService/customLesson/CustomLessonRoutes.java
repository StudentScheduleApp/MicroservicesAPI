package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.customLesson;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CustomLessonRoutes {
    @Autowired
    private CreateCustomLessonRoute createCustomLessonRoute;
    @Autowired
    private DeleteCustomLessonRoute deleteCustomLessonRoute;
    @Autowired
    private EditCustomLessonRoute editCustomLessonRoute;
    @Autowired
    private GetCustomLessonByIdRoute getCustomLessonByIdRoute;
    @Autowired
    private GetCustomLessonsByGroupIdRoute getCustomLessonsByGroupIdRoute;
}
