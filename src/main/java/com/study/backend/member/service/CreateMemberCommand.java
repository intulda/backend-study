package com.study.backend.member.service;

public record CreateMemberCommand(String email, String password, String name) {
}
