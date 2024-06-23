package com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize;

import com.studentscheduleapp.microservicesapi.identityservice.models.Member;
import com.studentscheduleapp.microservicesapi.identityservice.models.MemberRole;
import com.studentscheduleapp.microservicesapi.identityservice.models.Role;
import com.studentscheduleapp.microservicesapi.identityservice.models.SpecificLesson;
import com.studentscheduleapp.microservicesapi.identityservice.repos.MemberRepository;
import com.studentscheduleapp.microservicesapi.identityservice.repos.SpecificLessonRepository;
import com.studentscheduleapp.microservicesapi.identityservice.repos.UserRepository;
import com.studentscheduleapp.microservicesapi.identityservice.security.JwtProvider;
import com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize.utils.CheckUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificLessonAuthorizeService extends Authorized {
    private static final Logger log = LogManager.getLogger(SpecificLessonAuthorizeService.class);
    private final MemberRepository memberRepository;
    private final SpecificLessonRepository specificLessonRepository;
    private final CheckUtil checkUtil;

    public SpecificLessonAuthorizeService(UserRepository userRepository, JwtProvider jwtProvider, MemberRepository memberRepository, SpecificLessonRepository specificLessonRepository, CheckUtil checkUtil) {
        super(userRepository, jwtProvider);
        this.memberRepository = memberRepository;
        this.specificLessonRepository = specificLessonRepository;
        this.checkUtil = checkUtil;
    }

    @Override
    protected boolean authorizeDelete() {
        try {
            if (!user.getRoles().contains(Role.ADMIN) && !checkUserForGroupAdmin())
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
            if (params.contains("id") || params.contains("groupId")
                    || params.contains("lessonId") || params.contains("time"))
                return false;
            return checkUserForGroupAdmin();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected boolean authorizeCreate() {
        try {
            if (!user.getRoles().contains(Role.ADMIN) && !checkUserForGroupAdmin()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
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

    private boolean checkUserForGroupAdmin() throws Exception {
        for (Long id : ids) {
            SpecificLesson st = specificLessonRepository.getById(id);
            if (st == null)
                continue;
            List<Member> members = memberRepository.getByGroupId(st.getGroupId());
            if (members == null || members.isEmpty())
                continue;
            if (!checkUtil.checkUserForMemberRole(members, user, MemberRole.ADMIN)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUserForMember() throws Exception {
        for (Long id : ids) {
            SpecificLesson st = specificLessonRepository.getById(id);
            if (st == null)
                continue;
            List<Member> members = memberRepository.getByGroupId(st.getGroupId());
            if (members == null || members.isEmpty())
                continue;
            if (!checkUtil.checkUserForMemberRole(members, user, MemberRole.MEMBER)) {
                return false;
            }
        }
        return true;
    }
}
