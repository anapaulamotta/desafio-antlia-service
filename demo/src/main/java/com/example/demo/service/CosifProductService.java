package com.example.demo.service;

import com.example.demo.domain.CosifProduct;
import com.example.demo.domain.Product;
import com.example.demo.dto.CosifProductDTO;
import com.example.demo.repository.CosifProductRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CosifProductService {

    @Autowired
    CosifProductRepository repository;
    @Autowired
    ProductRepository productRepository;

    public List<CosifProductDTO> getCosifByProduct(String productCode) {

        Optional<Product> product = productRepository.getByProductCode(productCode);
        List<CosifProduct> cosifProducts = new ArrayList<>();
        List<CosifProductDTO> dtos = new ArrayList<>();

        if (product.isPresent())
            cosifProducts = repository.findByProduct(product.get());


        for (CosifProduct cosifProduct:cosifProducts){
            CosifProductDTO dto = new CosifProductDTO();

            String cosifCodeClassification = cosifProduct.getCosifCode() + " - " + cosifProduct.getClassificationCode();

            dto.setCosifCode(cosifProduct.getCosifCode());
            dto.setCosifCodeClassification(cosifCodeClassification);

            dtos.add(dto);

        }
        return dtos;

    }
}
