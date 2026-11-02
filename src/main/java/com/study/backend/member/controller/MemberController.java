package com.study.backend.member.controller;

import com.study.backend.member.entity.Member;
import com.study.backend.member.service.CreateMemberCommand;
import com.study.backend.member.dto.MemberCreateRequest;
import com.study.backend.member.dto.MemberCreateResponse;
import com.study.backend.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest request) {
        Member response = memberService.createMember(
                new CreateMemberCommand(
                        request.email(),
                        request.password(),
                        request.name()
                )
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(new MemberCreateResponse(1L, response.getEmail(), response.getName()));
    }
}
