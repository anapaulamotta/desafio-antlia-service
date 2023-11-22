package com.example.demo.domain;

import com.example.demo.domain.pk.ManualMovementPk;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "movimento_manual")
@Data
@Setter
public class ManualMovement implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ManualMovementPk id = new ManualMovementPk();
    @JoinColumn(name = "cod_produto")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "cod_cosif")
    @ManyToOne
    private CosifProduct cosif;
    @Column(name = "des_descricao")
    private String description;
    @Column(name = "dat_movimento")
    private LocalDateTime movementDate;
    @Column(name = "cod_usuario")
    private String userCode;
    @Column(name = "val_valor")
    private BigDecimal value;

}
