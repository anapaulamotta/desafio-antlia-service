package com.example.demo.repository;

import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "SELECT * FROM PRODUTO WHERE cod_produto = :productCode", nativeQuery = true)
    Optional<Product> getByProductCode(@Param("productCode") String productCode);

}
