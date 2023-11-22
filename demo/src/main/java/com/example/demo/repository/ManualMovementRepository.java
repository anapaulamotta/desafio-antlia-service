package com.example.demo.repository;

import com.example.demo.domain.ManualMovement;
import com.example.demo.domain.pk.ManualMovementPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ManualMovementRepository extends JpaRepository<ManualMovement, ManualMovementPk> {

    @Query(value = "SELECT COALESCE(MAX(num_lancamento) + 1, 1) AS num_release " +
            "FROM movimento_manual " +
            "WHERE dat_mes = :movement_month " +
            "AND dat_ano = :year", nativeQuery = true)
    Optional<Integer> getReleaseNumber(@Param("movement_month") Integer month, @Param("year") Integer year);

}
