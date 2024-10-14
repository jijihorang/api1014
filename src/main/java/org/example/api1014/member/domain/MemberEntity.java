package org.example.api1014.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class MemberEntity {

    @Id
    private String email;

    private String pw;

    // 이놈이 문제
    private MemberRole role;

}
