package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.member;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class MemberRoutes {
    @Autowired
    private GetMemberByIdRoute getMemberByIdRoute;
    @Autowired
    private GetMemberByUserIdRoute getMemberByUserIdRoute;
    @Autowired
    private GetMembersByGroupIdRoute getMembersByGroupIdRoute;
    @Autowired
    private EditMemberRoute editMemberRoute;
    @Autowired
    private DeleteMemberRoute deleteMemberRoute;
    @Autowired
    private CreateMemberRoute createMemberRoute;
}
