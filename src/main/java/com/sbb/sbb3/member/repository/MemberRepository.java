package com.sbb.sbb3.member.repository;

import com.sbb.sbb3.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
