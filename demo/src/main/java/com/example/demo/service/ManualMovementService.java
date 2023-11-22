package com.example.demo.service;

import com.example.demo.domain.CosifProduct;
import com.example.demo.domain.ManualMovement;
import com.example.demo.domain.Product;
import com.example.demo.domain.pk.ManualMovementPk;
import com.example.demo.dto.MovementRequestDTO;
import com.example.demo.dto.MovementResponseDTO;
import com.example.demo.mapper.ManualMovementMapper;
import com.example.demo.repository.CosifProductRepository;
import com.example.demo.repository.ManualMovementRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ManualMovementService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CosifProductRepository cosifRepository;

    @Autowired
    ManualMovementMapper mapper;

    @Autowired
    ManualMovementRepository repository;

    public List<MovementResponseDTO> movementRecord(MovementRequestDTO requestDTO){

        ManualMovement movement = new ManualMovement();
        ManualMovementPk pk = new ManualMovementPk();

        Optional<Product> product = productRepository.getByProductCode(requestDTO.getProductCode());
        Optional<CosifProduct> cosif = cosifRepository.getByCosifCode(requestDTO.getCosifCode());

        Optional<Integer>release = repository.getReleaseNumber(requestDTO.getMonth(), requestDTO.getYear());

        pk.setMonth(requestDTO.getMonth());
        pk.setYear(requestDTO.getYear());

        release.ifPresent(pk::setReleaseNumber);

        movement.setId(pk);

        product.ifPresent(movement::setProduct);
        cosif.ifPresent(movement::setCosif);

        movement.setDescription(requestDTO.getDescription());
        movement.setMovementDate(LocalDateTime.now());
        movement.setUserCode("Teste");
        movement.setValue(requestDTO.getValue());

        repository.save(movement);

        return mapper.toResponseDTOs(repository.findAll());

    }


}
