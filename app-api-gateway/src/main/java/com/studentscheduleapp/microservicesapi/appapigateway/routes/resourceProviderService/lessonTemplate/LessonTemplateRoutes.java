package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.lessonTemplate;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class LessonTemplateRoutes {
    @Autowired
    private CreateLessonTemplateRoute createLessonTemplateRoute;
    @Autowired
    private DeleteLessonTemplateRoute deleteLessonTemplateRoute;
    @Autowired
    private EditLessonTemplateRoute editLessonTemplateRoute;
    @Autowired
    private GetLessonTemplateByIdRoute getLessonTemplateByIdRoute;
    @Autowired
    private GetLessonTemplatesByScheduleTemplateIdRoute getLessonTemplatesByScheduleTemplateIdRoute;
}
