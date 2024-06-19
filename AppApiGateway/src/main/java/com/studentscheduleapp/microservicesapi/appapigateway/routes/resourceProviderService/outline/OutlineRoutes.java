package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.outline;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class OutlineRoutes {
    @Autowired
    private CreateOutlineRoute createOutlineRoute;
    @Autowired
    private DeleteOutlineRoute deleteOutlineRoute;
    @Autowired
    private EditOutlineRoute editOutlineRoute;
    @Autowired
    private GetOutlineByUserIdRoute getOutlineByUserIdRoute;
    @Autowired
    private GetOutlineBySpecificLessonIdRoute getOutlineBySpecificLessonIdRoute;
    @Autowired
    private GetOutlineByIdRoute getOutlineByIdRoute;
}
