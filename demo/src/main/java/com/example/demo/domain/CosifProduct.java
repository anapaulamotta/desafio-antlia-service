package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "produto_cosif")
@Data
public class CosifProduct {
    @Id
    @Column(name = "cod_cosif")
    private String cosifCode;
    @Column(name = "cod_classificacao")
    private String classificationCode;
    @Column(name = "sta_status")
    private Character status;
    @JoinColumn(name = "cod_produto")
    @JsonIgnore
    @ManyToOne
    private Product product;
}
