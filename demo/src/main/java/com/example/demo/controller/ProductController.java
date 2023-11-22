package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
@CrossOrigin("http://localhost:4200")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<ProductDTO> getProducts(){
        return service.findAll();
    }

}
