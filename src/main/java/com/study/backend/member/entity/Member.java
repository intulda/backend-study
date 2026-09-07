package com.study.backend.member.entity;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static Member create(
            String email,
            String password,
            String name
    ) {
        Member member = new Member();
        member.email = email;
        member.password = password;
        member.name = name;
        member.createdAt = LocalDateTime.now();
        member.modifiedAt = LocalDateTime.now();
        return member;
    }
}
