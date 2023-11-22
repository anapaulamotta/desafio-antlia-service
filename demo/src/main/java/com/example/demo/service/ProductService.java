package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductDTO;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<ProductDTO> findAll() {

        List<Product> products = repository.findAll();

        List<ProductDTO> dtos = new ArrayList<>();

        for (Product product:products){
            ProductDTO dto = new ProductDTO();
            dto.setProductCode(product.getProductCode());
            dto.setProductDescription(product.getProductDescription());

            dtos.add(dto);
        }

        return dtos;

    }
}
