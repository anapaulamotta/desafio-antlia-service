package com.example.demo.controller;

import com.example.demo.dto.MovementRequestDTO;
import com.example.demo.dto.MovementResponseDTO;
import com.example.demo.mapper.ManualMovementMapper;
import com.example.demo.repository.ManualMovementRepository;
import com.example.demo.service.ManualMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movement")
@CrossOrigin(origins = "http://localhost:4200")
public class ManualMovementController {

    @Autowired
    ManualMovementService service;

    @Autowired
    ManualMovementRepository repository;

    @Autowired
    ManualMovementMapper mapper;

    @GetMapping("/movements")
    public List<MovementResponseDTO> getMovements(){
        return mapper.toResponseDTOs(repository.findAll());
    }

    @PostMapping
    public List<MovementResponseDTO> movementRecord(@RequestBody MovementRequestDTO requestDTO){
        return service.movementRecord(requestDTO);
    }
}
