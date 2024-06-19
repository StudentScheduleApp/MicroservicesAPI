package com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize;

import com.studentscheduleapp.microservicesapi.identityservice.models.Member;
import com.studentscheduleapp.microservicesapi.identityservice.models.MemberRole;
import com.studentscheduleapp.microservicesapi.identityservice.models.Role;
import com.studentscheduleapp.microservicesapi.identityservice.models.ScheduleTemplate;
import com.studentscheduleapp.microservicesapi.identityservice.repos.MemberRepository;
import com.studentscheduleapp.microservicesapi.identityservice.repos.ScheduleTemplateRepository;
import com.studentscheduleapp.microservicesapi.identityservice.repos.UserRepository;
import com.studentscheduleapp.microservicesapi.identityservice.security.JwtProvider;
import com.studentscheduleapp.microservicesapi.identityservice.services.userauthorize.utils.CheckUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleTemplateAuthorizeService extends Authorized {
    private static final Logger log = LogManager.getLogger(ScheduleTemplateAuthorizeService.class);
    private final MemberRepository memberRepository;
    private final ScheduleTemplateRepository scheduleTemplateRepository;
    private final CheckUtil checkUtil;

    public ScheduleTemplateAuthorizeService(UserRepository userRepository, JwtProvider jwtProvider, MemberRepository memberRepository, ScheduleTemplateRepository scheduleTemplateRepository, CheckUtil checkUtil) {
        super(userRepository, jwtProvider);
        this.memberRepository = memberRepository;
        this.scheduleTemplateRepository = scheduleTemplateRepository;
        this.checkUtil = checkUtil;
    }

    @Override
    protected boolean authorizeDelete() {
        try {
            if (!checkUserForGroupAdmin() && !user.getRoles().contains(Role.ADMIN))
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
            return checkUserForGroupAdmin();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected boolean authorizeCreate() {
        try {
            return checkUserForGroupAdmin();
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

    private boolean checkUserForGroupAdmin() throws Exception {
        for (Long id : ids) {
            ScheduleTemplate st = scheduleTemplateRepository.getById(id);
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
            ScheduleTemplate st = scheduleTemplateRepository.getById(id);
            if (st == null)
                continue;
            List<Member> members = memberRepository.getByGroupId(st.getGroupId());
            if (!checkUtil.checkUserForMemberRole(members, user, MemberRole.MEMBER)) {
                return false;
            }
        }
        return true;
    }
}
