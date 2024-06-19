package com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize;

import com.studentscheduleapp.microservicesapi.identityservice.models.*;
import com.studentscheduleapp.microservicesapi.identityservice.repos.MemberRepository;
import com.studentscheduleapp.microservicesapi.identityservice.repos.OutlineRepository;
import com.studentscheduleapp.microservicesapi.identityservice.repos.SpecificLessonRepository;
import com.studentscheduleapp.microservicesapi.identityservice.repos.UserRepository;
import com.studentscheduleapp.microservicesapi.identityservice.security.JwtProvider;
import com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize.utils.CheckUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutlineAuthorizeService extends Authorized {
    private static final Logger log = LogManager.getLogger(OutlineAuthorizeService.class);
    private final OutlineRepository outlineRepository;
    private final SpecificLessonRepository specificLessonRepository;
    private final MemberRepository memberRepository;
    private final CheckUtil checkUtil;

    public OutlineAuthorizeService(UserRepository userRepository, JwtProvider jwtProvider, OutlineRepository outlineRepository, SpecificLessonRepository specificLessonRepository, MemberRepository memberRepository, CheckUtil checkUtil) {
        super(userRepository, jwtProvider);
        this.outlineRepository = outlineRepository;
        this.specificLessonRepository = specificLessonRepository;
        this.memberRepository = memberRepository;
        this.checkUtil = checkUtil;
    }

    @Override
    protected boolean authorizeDelete() {
        try {
            if (!checkUserForOutlineOwner() && !checkUserForAdmin() && !user.getRoles().contains(Role.ADMIN))
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    protected boolean authorizePatch() {
        try {
            if (params.contains("id") || params.contains("userId") || params.contains("specificLessonId"))
                return false;
            return checkUserForAdmin();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected boolean authorizeCreate() {
        try {
            return checkUserForMember();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected boolean authorizeGet() {
        try {
            return checkUserForMember();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkUserForOutlineOwner() throws Exception {
        if (user.getRoles().contains(Role.ADMIN)) {
            return true;
        }
        for (Long id : ids) {
            Outline outline = outlineRepository.getById(id);
            if (outline == null)
                continue;
            if (outline.getUserId() == user.getId()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkUserForAdmin() throws Exception {
        for (Long id : ids) {
            Outline outline = outlineRepository.getById(id);
            if (outline == null)
                continue;
            SpecificLesson specificLesson = specificLessonRepository.getById(outline.getSpecificLessonId());
            List<Member> members = memberRepository.getByGroupId(specificLesson.getGroupId());
            if (!checkUtil.checkUserForMemberRole(members, user, MemberRole.ADMIN)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUserForMember() throws Exception {
        for (Long id : ids) {
            Outline outline = outlineRepository.getById(id);
            if (outline == null)
                continue;
            SpecificLesson specificLesson = specificLessonRepository.getById(outline.getSpecificLessonId());
            List<Member> members = memberRepository.getByGroupId(specificLesson.getGroupId());
            if (!checkUtil.checkUserForMemberRole(members, user, MemberRole.MEMBER)) {
                return false;
            }
        }
        return true;
    }

}
