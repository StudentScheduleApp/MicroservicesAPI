package com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize;

import com.studentscheduleapp.microservicesapi.identityservice.models.Member;
import com.studentscheduleapp.microservicesapi.identityservice.models.MemberRole;
import com.studentscheduleapp.microservicesapi.identityservice.models.Role;
import com.studentscheduleapp.microservicesapi.identityservice.repos.CustomLessonRepository;
import com.studentscheduleapp.microservicesapi.identityservice.repos.MemberRepository;
import com.studentscheduleapp.microservicesapi.identityservice.repos.UserRepository;
import com.studentscheduleapp.microservicesapi.identityservice.security.JwtProvider;
import com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize.utils.CheckUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomLessonAuthorizeService extends Authorized {
    private static final Logger log = LogManager.getLogger(CustomLessonAuthorizeService.class);
    private final CustomLessonRepository customLessonRepository;
    private final MemberRepository memberRepository;
    private final CheckUtil checkUtil;

    public CustomLessonAuthorizeService(UserRepository userRepository, JwtProvider jwtProvider, CustomLessonRepository customLessonRepository, MemberRepository memberRepository, CheckUtil checkUtil) {
        super(userRepository, jwtProvider);
        this.customLessonRepository = customLessonRepository;
        this.memberRepository = memberRepository;
        this.checkUtil = checkUtil;
    }

    @Override
    protected boolean authorizeDelete() {
        try {
            if (!checkUserForAdmin() && !user.getRoles().contains(Role.ADMIN))
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
            if (params.contains("id") || params.contains("groupId"))
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
            return checkUserForAdminCreate();
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

    private boolean checkUserForAdmin() throws Exception {
        for (Long id : ids) {
            List<Member> members = memberRepository.getByGroupId(customLessonRepository.getById(id).getGroupId());
            if (members == null || members.isEmpty())
                continue;
            if (!checkUtil.checkUserForMemberRole(members, user, MemberRole.ADMIN)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUserForAdminCreate() throws Exception {
        for (Long id : ids) {
            List<Member> members = memberRepository.getByGroupId(id);
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
            List<Member> members = memberRepository.getByGroupId(customLessonRepository.getById(id).getGroupId());
            if (members == null || members.isEmpty())
                continue;
            if (!checkUtil.checkUserForMemberRole(members, user, MemberRole.MEMBER)) {
                return false;
            }
        }
        return true;
    }
}
