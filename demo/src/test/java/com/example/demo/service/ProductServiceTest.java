package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductDTO;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository repository;
    @InjectMocks
    ProductService service;

    @Test
    void whenFindAll_success(){

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();
        products.add(product1);
        products.add(product2);

        when(repository.findAll()).thenReturn(products);

        List<ProductDTO> dtos = service.findAll();

        verify(repository, times(1)).findAll();

    }

}
