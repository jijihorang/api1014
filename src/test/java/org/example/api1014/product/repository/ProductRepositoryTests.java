package org.example.api1014.product.repository;

import lombok.extern.log4j.Log4j2;
import org.example.api1014.common.dto.PageRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@DataJpaTest
@Log4j2
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testList() {

        Pageable pageable = PageRequest.of(0,10);
        productRepository.list(pageable);
    }

    // 여기까지 완료하면 DTO 작업 후 다 만들면 insert 작업 실시
    @Test
    public void testList2() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        log.info(productRepository.listByCno(1L, pageRequestDTO));

    }

}
