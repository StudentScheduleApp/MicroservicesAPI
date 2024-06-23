package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.scheduleTemplate;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ScheduleTemplateRoutes {
    @Autowired
    private CreateScheduleTemplateRoute createScheduleTemplateRoute;
    @Autowired
    private DeleteScheduleTemplateRoute deleteScheduleTemplateRoute;
    @Autowired
    private EditScheduleTemplateRoute editScheduleTemplateRoute;
    @Autowired
    private GetScheduleTemplateByIdRoute getScheduleTemplateByIdRoute;
    @Autowired
    private GetScheduleTemplateByGroupIdRoute getScheduleTemplateByGroupIdRoute;

}
