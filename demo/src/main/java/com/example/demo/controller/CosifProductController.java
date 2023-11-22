package com.example.demo.controller;

import com.example.demo.dto.CosifProductDTO;
import com.example.demo.repository.CosifProductRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CosifProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cosif")
@CrossOrigin(origins = "http://localhost:4200")
public class CosifProductController {

    @Autowired
    CosifProductService service;

    @GetMapping("/cosifbyproduct/{productCode}")
    public List<CosifProductDTO> getCosifByProduct(@PathVariable String productCode){
        return service.getCosifByProduct(productCode);
    }

}
