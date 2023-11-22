package com.example.demo.repository;

import com.example.demo.domain.CosifProduct;
import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CosifProductRepository extends JpaRepository<CosifProduct, String> {
    List<CosifProduct> findByProduct(Product product);

    @Query(value = "SELECT * FROM PRODUTO_COSIF WHERE cod_cosif = :cosifCode", nativeQuery = true)
    Optional<CosifProduct> getByCosifCode(@Param("cosifCode") String cosifCode);
}
