package com.study.backend.member.service;

import com.study.backend.member.dto.MemberCreateResponse;
import com.study.backend.member.entity.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public Member createMember(CreateMemberCommand command) {
        return Member.create(
                command.email(),
                command.password(),
                command.name());
    }

}
