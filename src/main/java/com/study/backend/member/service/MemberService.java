package com.study.backend.member.service;

import com.study.backend.member.entity.Member;
import com.study.backend.member.exception.MemberNotFoundException;
import com.study.backend.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(CreateMemberCommand command) {
        Member newMember = Member.create(
                command.email(),
                command.password(),
                command.name());

        return memberRepository.save(newMember);
    }

    public Member findMember(Long id) {
        Optional<Member> findOptMember = memberRepository.findById(id);

        return findOptMember.orElseThrow(() -> new MemberNotFoundException(id));
    }
}
