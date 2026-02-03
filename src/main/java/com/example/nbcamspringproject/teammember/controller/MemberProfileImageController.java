package com.example.nbcamspringproject.teammember.controller;

import com.example.nbcamspringproject.teammember.dto.PresignedUrlResponse;
import com.example.nbcamspringproject.teammember.service.MemberProfileImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberProfileImageController {

    private final MemberProfileImageService service;

    @PostMapping("/{id}/profile-image")
    public ResponseEntity<Void> upload(
            @PathVariable Long id,
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        service.upload(id, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/profile-image")
    public ResponseEntity<PresignedUrlResponse> getProfileImage(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.getPresignedUrl(id));
    }
}
