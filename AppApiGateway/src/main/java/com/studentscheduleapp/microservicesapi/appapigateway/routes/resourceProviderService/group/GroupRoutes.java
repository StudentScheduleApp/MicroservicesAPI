package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.group;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class GroupRoutes {
    @Autowired
    private CreateGroupRoute createGroupRoute;
    @Autowired
    private DeleteGroupRoute deleteGroupRoute;
    @Autowired
    private EditGroupRoute editGroupRoute;
    @Autowired
    private GetGroupByIdRoute getGroupByIdRoute;
}
