package com.example.nbcamspringproject.teammember.dto;

import lombok.Getter;

import java.time.Instant;

@Getter
public class PresignedUrlResponse {
    private final String url;
    private final Instant expiresAt;

    public PresignedUrlResponse(String string, Instant plus) {
        this.url = string;
        this.expiresAt = plus;
    }
}
