package com.example.demo.domain.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ManualMovementPk {
    @Column(name = "dat_mes")
    private Integer month;
    @Column(name = "dat_ano")
    private Integer year;
    @Column(name = "num_lancamento")
    private Integer releaseNumber;

}
