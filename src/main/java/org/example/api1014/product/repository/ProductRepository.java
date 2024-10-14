package org.example.api1014.product.repository;

import org.example.api1014.product.domain.Product;
import org.example.api1014.product.repository.search.ProductSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductSearch {



}
