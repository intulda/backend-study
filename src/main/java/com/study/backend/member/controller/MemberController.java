package com.study.backend.member.controller;

import com.study.backend.member.dto.MemberCreateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @PostMapping("/member")
    public void createMember(@RequestBody MemberCreateRequest request) {

    }
}
