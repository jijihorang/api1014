package org.example.api1014.member.repository;

import lombok.extern.log4j.Log4j2;
import org.example.api1014.cart.repository.CartDetailsRepository;
import org.example.api1014.member.domain.MemberEntity;
import org.example.api1014.member.domain.MemberRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CartDetailsRepository cartDetailsRepository;

    @Test
    public void testCartList() {
        String email = "user@aaa.com";

        Pageable pageable = PageRequest.of(0, 10);

        cartDetailsRepository.listofMember(email,pageable);
    }

    @Test
    @Transactional
    @Commit
    public void testDummies() {

        for (int i = 0; i < 10; i++) {

            MemberEntity member = MemberEntity.builder()
                    .email("user"+i+"@aaa.com")
                    .pw(passwordEncoder.encode("1111"))
                    .role(i < 8 ? MemberRole.USER: MemberRole.ADMIN)
                    .build();

            memberRepository.save(member);

        } // end for

    }
}
