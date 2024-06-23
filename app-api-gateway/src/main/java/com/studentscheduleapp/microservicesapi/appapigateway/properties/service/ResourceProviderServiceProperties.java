package com.studentscheduleapp.microservicesapi.appapigateway.properties.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ResourceProviderServiceProperties {
    @Value("${resource.provider.service.uri}")
    private String uri;
    //User resources
    @Value("${resource.provider.service.user.path.idPath}")
    private String getUserByIdPath;
    @Value("${resource.provider.service.user.path.editPath}")
    private String userEditPath;
    //Member
    @Value("${resource.provider.service.member.path.idPath}")
    private String getMemberByIdPath;
    @Value("${resource.provider.service.member.path.groupIdPath}")
    private String getMembersByGroupIdPath;
    @Value("${resource.provider.service.member.path.userIdPath}")
    private String getMemberByUserIdPath;
    @Value("${resource.provider.service.member.path.editPath}")
    private String editMemberPath;
    @Value("${resource.provider.service.member.path.createPath}")
    private String createMemberPath;
    @Value("${resource.provider.service.member.path.deletePath}")
    private String deleteMemberPath;
    //Group
    @Value("${resource.provider.service.group.path.idPath}")
    private String getGroupByIdPath;
    @Value("${resource.provider.service.group.path.createPath}")
    private String createGroupPath;
    @Value("${resource.provider.service.group.path.editPath}")
    private String editGroupPath;
    @Value("${resource.provider.service.group.path.deletePath}")
    private String deleteGroupPath;
    //Outline
    @Value("${resource.provider.service.outline.path.idPath}")
    private String getOutlineByIdPath;
    @Value("${resource.provider.service.outline.path.createPath}")
    private String createOutlinePath;
    @Value("${resource.provider.service.outline.path.editPath}")
    private String editOutlinePath;
    @Value("${resource.provider.service.outline.path.deletePath}")
    private String deleteOutlinePath;
    @Value("${resource.provider.service.outline.path.specificLessonIdPath}")
    private String getOutlineBySpecificLessonIdPath;
    @Value("${resource.provider.service.outline.path.userIdPath}")
    private String getOutlineByUserIdPath;
    //Schedule Template
    @Value("${resource.provider.service.scheduleTemplate.path.idPath}")
    private String getScheduleTemplateByIdPath;
    @Value("${resource.provider.service.scheduleTemplate.path.groupIdPath}")
    private String getScheduleTemplateByGroupId;
    @Value("${resource.provider.service.scheduleTemplate.path.deletePath}")
    private String deleteScheduleTemplatePath;
    @Value("${resource.provider.service.scheduleTemplate.path.createPath}")
    private String createScheduleTemplatePath;
    @Value("${resource.provider.service.scheduleTemplate.path.editPath}")
    private String editScheduleTemplatePath;

    //Specific lesson
    @Value("${resource.provider.service.specificLesson.path.idPath}")
    private String getSpecificLessonByIdPath;
    @Value("${resource.provider.service.specificLesson.path.groupIdPath}")
    private String getSpecificLessonsByGroupIdPath;
    @Value("${resource.provider.service.specificLesson.path.createPath}")
    private String createSpecificLessonPath;
    @Value("${resource.provider.service.specificLesson.path.editPath}")
    private String editSpecificLessonPath;
    @Value("${resource.provider.service.specificLesson.path.deletePath}")
    private String deleteSpecificLessonPath;
    //Outline media
    @Value("${resource.provider.service.outlineMedia.path.idPath}")
    private String getOutlineMediaByIdPath;
    @Value("${resource.provider.service.outlineMedia.path.outlineIdPath}")
    private String getOutlineMediasByOutlineIdPath;
    @Value("${resource.provider.service.outlineMedia.path.createPath}")
    private String createOutlineMediaPath;
    @Value("${resource.provider.service.outlineMedia.path.deletePath}")
    private String deleteOutlineMediaPath;
    @Value("${resource.provider.service.outlineMedia.path.editPath}")
    private String editOutlineMediaPath;
    //Outline media comment
    @Value("${resource.provider.service.outlineMediaComment.path.idPath}")
    private String getOutlineMediaCommentByIdPath;
    @Value("${resource.provider.service.outlineMediaComment.path.outlineMediaPath}")
    private String getOutlineMediaCommentsByOutlineMediaPath;
    @Value("${resource.provider.service.outlineMediaComment.path.createPath}")
    private String createOutlineMediaCommentPath;
    @Value("${resource.provider.service.outlineMediaComment.path.editPath}")
    private String editOutlineMediaCommentPath;
    @Value("${resource.provider.service.outlineMediaComment.path.deletePath}")
    private String deleteOutlineMediaCommentPath;
    //Lesson template
    @Value("${resource.provider.service.lessonTemplate.path.idPath}")
    private String getLessonTemplateById;
    @Value("${resource.provider.service.lessonTemplate.path.scheduleTemplateIdPath}")
    private String getLessonTemplatesByScheduleTemplateId;
    @Value("${resource.provider.service.lessonTemplate.path.createPath}")
    private String createLessonTemplatePath;
    @Value("${resource.provider.service.lessonTemplate.path.editPath}")
    private String editLessonTemplatePath;
    @Value("${resource.provider.service.lessonTemplate.path.deletePath}")
    private String deleteLessonTemplatePath;
    //Custom lesson
    @Value("${resource.provider.service.customLesson.path.idPath}")
    private String getCustomLessonByIdPath;
    @Value("${resource.provider.service.customLesson.path.groupIdPath}")
    private String getCustomLessonsByGroupIdPath;
    @Value("${resource.provider.service.customLesson.path.createPath}")
    private String createCustomLessonPath;
    @Value("${resource.provider.service.customLesson.path.deletePath}")
    private String deleteCustomLessonPath;
    @Value("${resource.provider.service.customLesson.path.editPath}")
    private String editCustomLessonPath;
}
