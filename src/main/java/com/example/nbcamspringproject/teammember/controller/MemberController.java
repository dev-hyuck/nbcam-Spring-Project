package com.example.nbcamspringproject.teammember.controller;

import com.example.nbcamspringproject.teammember.dto.MemberRequest;
import com.example.nbcamspringproject.teammember.dto.MemberResponse;
import com.example.nbcamspringproject.teammember.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity save(@RequestBody MemberRequest request) {
        log.info("[POST] /api/members");
        return ResponseEntity.ok(memberService.save(request));
    }

    @GetMapping("/{id}")
    public MemberResponse find(@PathVariable Long id) {
        log.info("[GET] /api/members/{}", id);
        return memberService.find(id);
    }
}