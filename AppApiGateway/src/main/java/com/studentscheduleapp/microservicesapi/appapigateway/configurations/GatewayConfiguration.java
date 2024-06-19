package com.studentscheduleapp.microservicesapi.appapigateway.configurations;

import com.studentscheduleapp.microservicesapi.appapigateway.routes.identityService.IdentityServiceRoutes;
import com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.ResourceProviderRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Autowired
    private IdentityServiceRoutes identityServiceRoutes;
    @Autowired
    private ResourceProviderRoutes resourceProviderRoutes;
    @Bean
    RouteLocator routeLocator (RouteLocatorBuilder builder){
        return builder.routes()
                .route(identityServiceRoutes.getRegisterRoute().getRoute())
                .route(identityServiceRoutes.getRefreshRoute().getRoute())
                .route(identityServiceRoutes.getLoginRoute().getRoute())
                .route(identityServiceRoutes.getVerifyRoute().getRoute())
                .route(identityServiceRoutes.getGetUserByTokenRoute().getRoute())

                .route(resourceProviderRoutes.getGroupRoutes().getGetGroupByIdRoute().getRoute())
                .route(resourceProviderRoutes.getGroupRoutes().getCreateGroupRoute().getRoute())
                .route(resourceProviderRoutes.getGroupRoutes().getDeleteGroupRoute().getRoute())
                .route(resourceProviderRoutes.getGroupRoutes().getEditGroupRoute().getRoute())

                .route(resourceProviderRoutes.getMemberRoutes().getCreateMemberRoute().getRoute())
                .route(resourceProviderRoutes.getMemberRoutes().getGetMemberByIdRoute().getRoute())
                .route(resourceProviderRoutes.getMemberRoutes().getDeleteMemberRoute().getRoute())
                .route(resourceProviderRoutes.getMemberRoutes().getEditMemberRoute().getRoute())
                .route(resourceProviderRoutes.getMemberRoutes().getGetMemberByUserIdRoute().getRoute())
                .route(resourceProviderRoutes.getMemberRoutes().getGetMembersByGroupIdRoute().getRoute())

                .route(resourceProviderRoutes.getOutlineRoutes().getCreateOutlineRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineRoutes().getDeleteOutlineRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineRoutes().getEditOutlineRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineRoutes().getGetOutlineByIdRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineRoutes().getGetOutlineByUserIdRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineRoutes().getGetOutlineBySpecificLessonIdRoute().getRoute())

                .route(resourceProviderRoutes.getUserRoutes().getGetUserByIdRoute().getRoute())
                .route(resourceProviderRoutes.getUserRoutes().getEditUserRoute().getRoute())

                .route(resourceProviderRoutes.getCustomLessonRoutes().getCreateCustomLessonRoute().getRoute())
                .route(resourceProviderRoutes.getCustomLessonRoutes().getEditCustomLessonRoute().getRoute())
                .route(resourceProviderRoutes.getCustomLessonRoutes().getDeleteCustomLessonRoute().getRoute())
                .route(resourceProviderRoutes.getCustomLessonRoutes().getGetCustomLessonByIdRoute().getRoute())
                .route(resourceProviderRoutes.getCustomLessonRoutes().getGetCustomLessonsByGroupIdRoute().getRoute())

                .route(resourceProviderRoutes.getLessonTemplateRoutes().getCreateLessonTemplateRoute().getRoute())
                .route(resourceProviderRoutes.getLessonTemplateRoutes().getEditLessonTemplateRoute().getRoute())
                .route(resourceProviderRoutes.getLessonTemplateRoutes().getDeleteLessonTemplateRoute().getRoute())
                .route(resourceProviderRoutes.getLessonTemplateRoutes().getGetLessonTemplatesByScheduleTemplateIdRoute().getRoute())
                .route(resourceProviderRoutes.getLessonTemplateRoutes().getGetLessonTemplateByIdRoute().getRoute())

                .route(resourceProviderRoutes.getOutlineMediaCommentRoutes().getCreateOutlineMediaCommentRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineMediaCommentRoutes().getDeleteOutlineMediaCommentRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineMediaCommentRoutes().getEditOutlineMediaCommentRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineMediaCommentRoutes().getGetOutlineMediaCommentByIdRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineMediaCommentRoutes().getGetOutlineMediaCommentByOutlineMediaRoute().getRoute())

                .route(resourceProviderRoutes.getScheduleTemplateRoutes().getCreateScheduleTemplateRoute().getRoute())
                .route(resourceProviderRoutes.getScheduleTemplateRoutes().getDeleteScheduleTemplateRoute().getRoute())
                .route(resourceProviderRoutes.getScheduleTemplateRoutes().getEditScheduleTemplateRoute().getRoute())
                .route(resourceProviderRoutes.getScheduleTemplateRoutes().getGetScheduleTemplateByGroupIdRoute().getRoute())
                .route(resourceProviderRoutes.getScheduleTemplateRoutes().getGetScheduleTemplateByIdRoute().getRoute())

                .route(resourceProviderRoutes.getSpecificLessonRoutes().getEditSpecificLessonRoute().getRoute())
                .route(resourceProviderRoutes.getSpecificLessonRoutes().getCreateSpecificLessonRoute().getRoute())
                .route(resourceProviderRoutes.getSpecificLessonRoutes().getDeleteSpecificLessonRoute().getRoute())
                .route(resourceProviderRoutes.getSpecificLessonRoutes().getGetSpecificLessonByIdRoute().getRoute())
                .route(resourceProviderRoutes.getSpecificLessonRoutes().getGetSpecificLessonsByGroupIdRoute().getRoute())

                .route(resourceProviderRoutes.getOutlineMediaRoutes().getCreateOutlineMediaRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineMediaRoutes().getEditOutlineMediaRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineMediaRoutes().getDeleteOutlineMediaRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineMediaRoutes().getGetOutlineMediasByOutlineIdRoute().getRoute())
                .route(resourceProviderRoutes.getOutlineMediaRoutes().getGetOutlineMediaByIdRoute().getRoute())
                .build();
    }
}
