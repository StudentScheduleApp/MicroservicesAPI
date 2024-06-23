package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.outlineMediaComment;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class OutlineMediaCommentRoutes {
    @Autowired
    private GetOutlineMediaCommentByIdRoute getOutlineMediaCommentByIdRoute;
    @Autowired
    private GetOutlineMediaCommentByOutlineMediaRoute getOutlineMediaCommentByOutlineMediaRoute;
    @Autowired
    private EditOutlineMediaCommentRoute editOutlineMediaCommentRoute;
    @Autowired
    private DeleteOutlineMediaCommentRoute deleteOutlineMediaCommentRoute;
    @Autowired
    private CreateOutlineMediaCommentRoute createOutlineMediaCommentRoute;
}
