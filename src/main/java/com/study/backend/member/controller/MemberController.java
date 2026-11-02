package com.study.backend.member.controller;

import com.study.backend.member.dto.MemberFindResponse;
import com.study.backend.member.entity.Member;
import com.study.backend.member.service.CreateMemberCommand;
import com.study.backend.member.dto.MemberCreateRequest;
import com.study.backend.member.dto.MemberCreateResponse;
import com.study.backend.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberFindResponse> findMember(@PathVariable Long id) {
        Member member = memberService.findMember(id);

        return ResponseEntity.ok().body(new MemberFindResponse(member.getId(), member.getEmail(), member.getName()));

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

        return ResponseEntity.status(HttpStatus.CREATED).body(new MemberCreateResponse(response.getId(), response.getEmail(), response.getName()));
    }
}
