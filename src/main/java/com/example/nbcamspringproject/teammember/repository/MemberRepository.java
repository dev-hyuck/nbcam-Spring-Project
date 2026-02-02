package com.example.nbcamspringproject.teammember.repository;

import com.example.nbcamspringproject.teammember.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
