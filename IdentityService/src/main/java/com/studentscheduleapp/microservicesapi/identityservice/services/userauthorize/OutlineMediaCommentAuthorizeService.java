package com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize;

import com.studentscheduleapp.microservicesapi.identityservice.models.*;
import com.studentscheduleapp.microservicesapi.identityservice.repos.*;
import com.studentscheduleapp.microservicesapi.identityservice.security.JwtProvider;
import com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize.utils.CheckUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutlineMediaCommentAuthorizeService extends Authorized {
    private static final Logger log = LogManager.getLogger(OutlineMediaCommentAuthorizeService.class);
    private final MemberRepository memberRepository;
    private final OutlineMediaCommentRepository outlineMediaCommentRepository;
    private final OutlineMediaRepository outlineMediaRepository;
    private final OutlineRepository outlineRepository;
    private final SpecificLessonRepository specificLessonRepository;
    private final CheckUtil checkUtil;

    public OutlineMediaCommentAuthorizeService(UserRepository userRepository, JwtProvider jwtProvider, MemberRepository memberRepository, OutlineMediaCommentRepository outlineMediaCommentRepository, OutlineMediaRepository outlineMediaRepository, OutlineRepository outlineRepository, SpecificLessonRepository specificLessonRepository, CheckUtil checkUtil) {
        super(userRepository, jwtProvider);
        this.memberRepository = memberRepository;
        this.outlineMediaCommentRepository = outlineMediaCommentRepository;
        this.outlineMediaRepository = outlineMediaRepository;
        this.outlineRepository = outlineRepository;
        this.specificLessonRepository = specificLessonRepository;
        this.checkUtil = checkUtil;
    }

    @Override
    protected boolean authorizeDelete() {
        try {
            return checkUserForAdmin() || checkUserForCommentOwner();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected boolean authorizePatch() {
        try {
            return checkUserForAdmin() || checkUserForCommentOwner();
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

    private boolean checkUserForCommentOwner() throws Exception {
        for (Long id : ids) {
            OutlineMediaComment outlineMediaComment = outlineMediaCommentRepository.getById(id);
            if (outlineMediaComment == null)
                continue;
            if (outlineMediaComment.getUserId() != user.getId()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUserForAdmin() throws Exception {
        for (Long id : ids) {
            OutlineMediaComment outlineMediaComment = outlineMediaCommentRepository.getById(id);
            if (outlineMediaComment == null)
                continue;
            OutlineMedia outlineMedia = outlineMediaRepository.getById(outlineMediaComment.getMediaId());
            Outline outline = outlineRepository.getById(outlineMedia.getOutlineId());
            SpecificLesson specificLesson = specificLessonRepository.getById(outline.getSpecificLessonId());
            List<Member> memberList = memberRepository.getByGroupId(specificLesson.getGroupId());
            if (!checkUtil.checkUserForMemberRole(memberList, user, MemberRole.ADMIN)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUserForMember() throws Exception {
        for (Long id : ids) {
            OutlineMediaComment outlineMediaComment = outlineMediaCommentRepository.getById(id);
            if (outlineMediaComment == null)
                continue;
            OutlineMedia outlineMedia = outlineMediaRepository.getById(outlineMediaComment.getMediaId());
            Outline outline = outlineRepository.getById(outlineMedia.getOutlineId());
            SpecificLesson specificLesson = specificLessonRepository.getById(outline.getSpecificLessonId());
            List<Member> memberList = memberRepository.getByGroupId(specificLesson.getGroupId());
            if (!checkUtil.checkUserForMemberRole(memberList, user, MemberRole.MEMBER)) {
                return false;
            }
        }
        return true;
    }
}
