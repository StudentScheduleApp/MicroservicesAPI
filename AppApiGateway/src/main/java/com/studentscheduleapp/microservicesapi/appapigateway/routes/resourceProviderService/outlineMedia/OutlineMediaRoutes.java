package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.outlineMedia;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class OutlineMediaRoutes {
    @Autowired
    private CreateOutlineMediaRoute createOutlineMediaRoute;
    @Autowired
    private EditOutlineMediaRoute editOutlineMediaRoute;
    @Autowired
    private DeleteOutlineMediaRoute deleteOutlineMediaRoute;
    @Autowired
    private GetOutlineMediaByIdRoute getOutlineMediaByIdRoute;
    @Autowired
    private GetOutlineMediasByOutlineIdRoute getOutlineMediasByOutlineIdRoute;
}
