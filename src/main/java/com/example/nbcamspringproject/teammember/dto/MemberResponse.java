package com.example.nbcamspringproject.teammember.dto;

import lombok.Getter;

@Getter
public class MemberResponse {

    private final String name;
    private final int age;
    private final String mbti;

    public MemberResponse(String name, int age, String mbti) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }
}