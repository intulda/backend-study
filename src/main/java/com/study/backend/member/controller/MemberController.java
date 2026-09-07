package com.study.backend.member.controller;

import com.study.backend.member.dto.MemberCreateRequest;
import com.study.backend.member.entity.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @PostMapping
    public void createMember(@RequestBody MemberCreateRequest request) {
        Member member = Member.create(
                request.email(),
                request.password(),
                request.name()
        );

        System.out.println("Member: " + member);
    }
}
