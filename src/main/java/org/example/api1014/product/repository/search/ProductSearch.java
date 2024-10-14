package org.example.api1014.product.repository.search;

import org.example.api1014.common.dto.PageRequestDTO;
import org.example.api1014.common.dto.PageResponseDTO;
import org.example.api1014.product.domain.Product;
import org.example.api1014.product.dto.ProductListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductSearch {

    Page<Product> list(Pageable pageable);

    PageResponseDTO<ProductListDTO> listByCno(Long cno , PageRequestDTO pageRequestDTO);

}
