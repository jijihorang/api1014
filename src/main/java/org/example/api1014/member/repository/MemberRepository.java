package org.example.api1014.member.repository;

import org.example.api1014.member.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    @Query("""
    select m from MemberEntity m WHERE m.email = :email
""")
    MemberEntity findByEmail(@Param("email") String email);

}
