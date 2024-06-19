package com.studentscheduleapp.microservicesapi.identityservice.services;

import com.studentscheduleapp.microservicesapi.identityservice.models.api.AuthorizeEntity;
import com.studentscheduleapp.microservicesapi.identityservice.repos.*;
import com.studentscheduleapp.microservicesapi.identityservice.security.JwtProvider;
import com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize.*;
import com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize.utils.CheckUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class AuthorizeUserService {

    private static final Logger log = LogManager.getLogger(AuthorizeUserService.class);
    @Autowired
    private CustomLessonRepository customLessonRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private LessonTemplateRepository lessonTemplateRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private OutlineMediaCommentRepository outlineMediaCommentRepository;
    @Autowired
    private OutlineMediaRepository outlineMediaRepository;
    @Autowired
    private OutlineRepository outlineRepository;
    @Autowired
    private ScheduleTemplateRepository scheduleTemplateRepository;
    @Autowired
    private SpecificLessonRepository specificLessonRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private CheckUtil checkUtil;

    public boolean authorize(String token, AuthorizeEntity authorizeEntity) {
        Authorized auth;
        switch (authorizeEntity.getEntity()) {
            case CUSTOM_LESSON:
                auth = new CustomLessonAuthorizeService(userRepository, jwtProvider, customLessonRepository, memberRepository, checkUtil);
                break;
            case GROUP:
                auth = new GroupAuthorizeService(userRepository, jwtProvider, memberRepository, checkUtil);
                break;
            case LESSON_TEMPLATE:
                auth = new LessonTemplateAuthorizeService(userRepository, jwtProvider, lessonTemplateRepository, memberRepository, scheduleTemplateRepository, checkUtil);
                break;
            case MEMBER:
                auth = new MemberAuthorizeService(userRepository, jwtProvider, memberRepository, checkUtil);
                break;
            case OUTLINE_MEDIA_COMMENT:
                auth = new OutlineMediaCommentAuthorizeService(userRepository, jwtProvider, memberRepository, outlineMediaCommentRepository, outlineMediaRepository, outlineRepository, specificLessonRepository, checkUtil);
                break;
            case OUTLINE_MEDIA:
                auth = new OutlineMediaAuthorizeService(userRepository, jwtProvider, memberRepository, outlineMediaRepository, outlineRepository, specificLessonRepository, checkUtil);
                break;
            case OUTLINE:
                auth = new OutlineAuthorizeService(userRepository, jwtProvider, outlineRepository, specificLessonRepository, memberRepository, checkUtil);
                break;
            case SCHEDULE_TEMPLATE:
                auth = new ScheduleTemplateAuthorizeService(userRepository, jwtProvider, memberRepository, scheduleTemplateRepository, checkUtil);
                break;
            case SPECIFIC_LESSON:
                auth = new SpecificLessonAuthorizeService(userRepository, jwtProvider, memberRepository, specificLessonRepository, checkUtil);
                break;
            case USER:
                auth = new UserAuthorizeService(userRepository, jwtProvider);
                break;
            default:
                auth = null;
        }
        if (auth == null) {
            log.error("authorize failed: unknown entity " + authorizeEntity.getEntity().name());
            return false;
        }
        if (authorizeEntity.getParams() == null)
            authorizeEntity.setParams(Collections.emptyList());
        if (authorizeEntity.getIds() == null)
            authorizeEntity.setIds(Collections.emptyList());
        auth.init(token, authorizeEntity.getType(), authorizeEntity.getIds(), authorizeEntity.getParams());
        if (auth.authorize()) {
            log.info("authorize successful:" +
                    " user: " + jwtProvider.getAccessClaims(token).getSubject() +
                    " entity: " + authorizeEntity.getEntity().name() +
                    " type: " + authorizeEntity.getType().name() +
                    " params: " + Arrays.toString(authorizeEntity.getParams().toArray()) +
                    " ids: " + Arrays.toString(authorizeEntity.getIds().toArray()));
            return true;
        }
        return false;
    }
}
