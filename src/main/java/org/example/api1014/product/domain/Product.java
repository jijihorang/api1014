package org.example.api1014.product.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"attachFiles"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private String pname;

    private int price;

    @ElementCollection
    @Builder.Default
    private Set<String> tags = new HashSet<>();

    @ElementCollection
    @Builder.Default
    @BatchSize(size = 50)
    private Set<AttachFile> attachFiles = new HashSet<>();

    // 파일 추가
    public void addFile(String filename) {
        attachFiles.add(new AttachFile(attachFiles.size(),filename));
    }

    // 파일 전체 삭제
    public void clearFiles() {
        attachFiles.clear();
    }

    // 태그 추가
    public void addTag(String tag) {
        tags.add(tag);
    }

    // 태그 전체 삭제
    public void clearTag() {
        tags.clear();
    }
}
