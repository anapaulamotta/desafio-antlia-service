package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity(name = "produto")
@Data
public class Product {

    @Id
    @Column(name = "cod_produto")
    private String productCode;
    @Column(name = "des_produto")
    private String productDescription;
    @Column(name = "sta_status")
    private Character status;
    @OneToMany(mappedBy = "product")
    private List<CosifProduct> cosifProducts;

}
