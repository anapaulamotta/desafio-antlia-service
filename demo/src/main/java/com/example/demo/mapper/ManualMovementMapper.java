package com.example.demo.mapper;

import com.example.demo.domain.ManualMovement;
import com.example.demo.domain.Product;
import com.example.demo.domain.pk.ManualMovementPk;
import com.example.demo.dto.MovementResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManualMovementMapper {


    public List<MovementResponseDTO> toResponseDTOs(List<ManualMovement> movements){

        List<MovementResponseDTO> dtos = new ArrayList<>();

        for (ManualMovement movement:movements){
            MovementResponseDTO dto = new MovementResponseDTO();

            ManualMovementPk pk = movement.getId();
            Product product = movement.getProduct();

            dto.setMonth(pk.getMonth().toString());
            dto.setYear(pk.getYear().toString());
            dto.setProductCode(product.getProductCode());
            dto.setProductDescription(product.getProductDescription());
            dto.setReleaseNumber(pk.getReleaseNumber().toString());
            dto.setDescription(movement.getDescription());
            dto.setValue(movement.getValue().toString());

            dtos.add(dto);

        }

        return dtos;

    }
}
