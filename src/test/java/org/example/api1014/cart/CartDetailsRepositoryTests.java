package org.example.api1014.cart;

import lombok.extern.log4j.Log4j2;
import org.example.api1014.cart.domain.Cart;
import org.example.api1014.cart.domain.CartDetails;
import org.example.api1014.cart.dto.CartDetailsListDTO;
import org.example.api1014.cart.repository.CartDetailsRepository;
import org.example.api1014.cart.repository.CartRepository;
import org.example.api1014.member.domain.MemberEntity;
import org.example.api1014.member.domain.MemberRole;
import org.example.api1014.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Log4j2
public class CartDetailsRepositoryTests {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    @Commit
    public void testCartDummies() {

        MemberEntity member = MemberEntity.builder()
                .email("user10@aaa.com")
                .pw(passwordEncoder.encode("1111"))
                .role(MemberRole.USER)
                .build();
        memberRepository.save(member);


        log.info(member);

        Cart cart = Cart.builder()
                .member(member)
                .build();
        cartRepository.save(cart);

    }
}
