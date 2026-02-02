package com.example.nbcamspringproject.teammember.service;

import com.example.nbcamspringproject.teammember.dto.MemberRequest;
import com.example.nbcamspringproject.teammember.dto.MemberResponse;
import com.example.nbcamspringproject.teammember.entity.Member;
import com.example.nbcamspringproject.teammember.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberRequest request) {
        Member member = new Member(
                request.getName(),
                request.getAge(),
                request.getMbti()
        );
        return memberRepository.save(member).getId();
    }

    @Transactional(readOnly = true)
    public MemberResponse find(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("멤버 없음"));

        return new MemberResponse(
                member.getName(),
                member.getAge(),
                member.getMbti()
        );
    }
}