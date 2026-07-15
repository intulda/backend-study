package com.study.backend.member.dto;

public record MemberCreateRequest(String email, String password, String name) {
}
