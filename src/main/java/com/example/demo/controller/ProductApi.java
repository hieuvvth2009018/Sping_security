package com.example.demo.controller;

import com.example.demo.search.Product;
import com.example.demo.entity.dto.ProductDTO;
import com.example.demo.enums.ProductSimpleStatus;
import com.example.demo.repository.ProductRepository;
import com.example.demo.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
        // tạo ra product từ productdto
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(product.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setSlug(StringHelper.toSlug(productDTO.getName()));
        product.setStatus(ProductSimpleStatus.ACTIVE);
        productRepository.save(product);
        productDTO.setId(product.getId());
        productDTO.setCreatedAt(product.getCreatedAt() == null ? "" : product.getCreatedAt().toString());
        productDTO.setUpdatedAt(product.getUpdatedAt() == null ? "" : product.getUpdatedAt().toString());
        productDTO.setStatus(product.getStatus().name());
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
}
