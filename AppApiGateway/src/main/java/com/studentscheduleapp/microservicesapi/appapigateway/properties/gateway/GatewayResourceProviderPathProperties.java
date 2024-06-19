package com.studentscheduleapp.microservicesapi.appapigateway.properties.gateway;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class GatewayResourceProviderPathProperties {
    //User
    @Value("${gateway.resource.provider.user.path.idPath}")
    private String getUserByIdPath;
    @Value("${gateway.resource.provider.user.path.editPath}")
    private String editUserPath;
    //Member
    @Value("${gateway.resource.provider.member.path.idPath}")
    private String getMemberByIdPath;
    @Value("${gateway.resource.provider.member.path.groupIdPath}")
    private String getMembersByGroupIdPath;
    @Value("${gateway.resource.provider.member.path.userIdPath}")
    private String getMemberByUserIdPath;
    @Value("${gateway.resource.provider.member.path.editPath}")
    private String editMemberPath;
    @Value("${gateway.resource.provider.member.path.createPath}")
    private String createMemberPath;
    @Value("${gateway.resource.provider.member.path.deletePath}")
    private String deleteMemberPath;
    //Group
    @Value("${gateway.resource.provider.group.path.idPath}")
    private String getGroupByIdPath;
    @Value("${gateway.resource.provider.group.path.createPath}")
    private String createGroupPath;
    @Value("${gateway.resource.provider.group.path.editPath}")
    private String editGroupPath;
    @Value("${gateway.resource.provider.group.path.deletePath}")
    private String deleteGroupPath;
    //Outline
    @Value("${gateway.resource.provider.outline.path.idPath}")
    private String getOutlineByIdPath;
    @Value("${gateway.resource.provider.outline.path.createPath}")
    private String createOutlineByIdPath;
    @Value("${gateway.resource.provider.outline.path.editPath}")
    private String editOutlinePath;
    @Value("${gateway.resource.provider.outline.path.deletePath}")
    private String deleteOutlinePath;
    @Value("${gateway.resource.provider.outline.path.specificLessonIdPath}")
    private String getOutlineBySpecificLessonIdPath;
    @Value("${gateway.resource.provider.outline.path.userIdPath}")
    private String getOutlineByUserIdPath;
    //ScheduleTemplate
    @Value("${gateway.resource.provider.sceduleTemplate.path.idPath}")
    private String getScheduleTemplateByIdPath;
    @Value("${gateway.resource.provider.sceduleTemplate.path.groupIdPath}")
    private String getScheduleTemplateByGroupIdPath;
    @Value("${gateway.resource.provider.sceduleTemplate.path.deletePath}")
    private String deleteScheduleTemplatePath;
    @Value("${gateway.resource.provider.sceduleTemplate.path.createPath}")
    private String createScheduleTemplatePath;
    @Value("${gateway.resource.provider.sceduleTemplate.path.editPath}")
    private String editScheduleTemplatePath;
    //Specific lesson
    @Value("${gateway.resource.provider.specificLesson.path.idPath}")
    private String getSpecificLessonByIdPath;
    @Value("${gateway.resource.provider.specificLesson.path.groupIdPath}")
    private String getSpecificLessonsByGroupIdPath;
    @Value("${gateway.resource.provider.specificLesson.path.createPath}")
    private String createSpecificLessonPath;
    @Value("${gateway.resource.provider.specificLesson.path.editPath}")
    private String editSpecificLessonPath;
    @Value("${gateway.resource.provider.specificLesson.path.deletePath}")
    private String deleteSpecificLessonPath;
    //Outline media
    @Value("${gateway.resource.provider.outlineMedia.path.idPath}")
    private String getOutlineMediaByIdPath;
    @Value("${gateway.resource.provider.outlineMedia.path.outlineIdPath}")
    private String getOutlineMediasByOutlineIdPath;
    @Value("${gateway.resource.provider.outlineMedia.path.createPath}")
    private String createOutlineMediaPath;
    @Value("${gateway.resource.provider.outlineMedia.path.deletePath}")
    private String deleteOutlineMediaPath;
    @Value("${gateway.resource.provider.outlineMedia.path.editPath}")
    private String editOutlineMediaPath;
    //Outline media comment
    @Value("${gateway.resource.provider.outlineMediaComment.path.idPath}")
    private String getOutlineMediaCommentByIdPath;
    @Value("${gateway.resource.provider.outlineMediaComment.path.outlineMediaPath}")
    private String getOutlineMediaCommentsByOutlineMediaPath;
    @Value("${gateway.resource.provider.outlineMediaComment.path.createPath}")
    private String createOutlineMediaCommentPath;
    @Value("${gateway.resource.provider.outlineMediaComment.path.editPath}")
    private String editOutlineMediaCommentPath;
    @Value("${gateway.resource.provider.outlineMediaComment.path.deletePath}")
    private String deleteOutlineMediaCommentPath;
    //Lesson template
    @Value("${gateway.resource.provider.lessonTemplate.path.idPath}")
    private String getLessonTemplateById;
    @Value("${gateway.resource.provider.lessonTemplate.path.scheduleTemplateIdPath}")
    private String getLessonTemplatesByScheduleTemplateId;
    @Value("${gateway.resource.provider.lessonTemplate.path.createPath}")
    private String createLessonTemplatePath;
    @Value("${gateway.resource.provider.lessonTemplate.path.editPath}")
    private String editLessonTemplatePath;
    @Value("${gateway.resource.provider.lessonTemplate.path.deletePath}")
    private String deleteLessonTemplatePath;
    //Custom lesson
    @Value("${gateway.resource.provider.customLesson.path.idPath}")
    private String getCustomLessonByIdPath;
    @Value("${gateway.resource.provider.customLesson.path.groupIdPath}")
    private String getCustomLessonsByGroupIdPath;
    @Value("${gateway.resource.provider.customLesson.path.createPath}")
    private String createCustomLessonPath;
    @Value("${gateway.resource.provider.customLesson.path.deletePath}")
    private String deleteCustomLessonPath;
    @Value("${gateway.resource.provider.customLesson.path.editPath}")
    private String editCustomLessonPath;
}
