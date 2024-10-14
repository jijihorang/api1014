package org.example.api1014.product.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "product")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String reviewText;

    // @JoinColumn -> 인덱스 설정 시 필요 !
    @ManyToOne(fetch = FetchType.LAZY) // 기본으로 설정하기
    private Product product;
}
