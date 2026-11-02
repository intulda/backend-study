package com.study.backend.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
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
