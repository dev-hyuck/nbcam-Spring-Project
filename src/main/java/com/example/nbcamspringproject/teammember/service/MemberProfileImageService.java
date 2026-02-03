package com.example.nbcamspringproject.teammember.service;

import com.example.nbcamspringproject.teammember.dto.PresignedUrlResponse;
import com.example.nbcamspringproject.teammember.entity.Member;
import com.example.nbcamspringproject.teammember.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberProfileImageService {

    private final S3Client s3Client;
    private final S3Presigner s3Presigner;
    private final MemberRepository memberRepository;

    @Value("${app.s3.bucket}")
    private String bucket;

    public void upload(Long memberId, MultipartFile file) throws IOException {

        // 1. 파일 검증
        if (file.isEmpty()) {
            throw new IllegalArgumentException("파일이 비어있습니다.");
        }
        if (file.getContentType() == null || !file.getContentType().startsWith("image/")) {
            throw new IllegalArgumentException("이미지 파일만 업로드 가능합니다.");
        }

        // 2. S3 key 생성
        String extension = getExtension(file.getOriginalFilename());
        String key = "members/" + memberId + "/profile/" + UUID.randomUUID() + extension;

        // 3. S3 업로드
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .contentType(file.getContentType())
                .build();

        s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));

        // 4. DB 업데이트
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("멤버가 존재하지 않습니다."));
        member.updateProfileImageKey(key);
    }

    /**
     * Presigned URL 조회 (7일)
     */
    @Transactional(readOnly = true)
    public PresignedUrlResponse getPresignedUrl(Long memberId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("멤버가 존재하지 않습니다."));

        if (member.getProfileImageKey() == null) {
            throw new IllegalArgumentException("프로필 이미지가 없습니다.");
        }

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucket)
                .key(member.getProfileImageKey())
                .build();

        Duration duration = Duration.ofDays(7); // 🚨 과제 필수

        PresignedGetObjectRequest presigned =
                s3Presigner.presignGetObject(builder ->
                        builder.getObjectRequest(getObjectRequest)
                                .signatureDuration(duration)
                );

        return new PresignedUrlResponse(
                presigned.url().toString(),
                Instant.now().plus(duration)
        );
    }

    private String getExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "";
        }
        return filename.substring(filename.lastIndexOf("."));
    }
}
