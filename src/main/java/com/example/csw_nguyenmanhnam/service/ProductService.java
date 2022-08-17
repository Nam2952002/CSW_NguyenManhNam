package com.example.csw_nguyenmanhnam.service;

import com.example.csw_nguyenmanhnam.entity.ProductEntity;
import com.example.csw_nguyenmanhnam.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<ProductEntity> getAllProduct() {
        return productRepo.findAll();
    }

    public ProductEntity addProduct(ProductEntity product){
        return productRepo.save(product);
    }

    public Optional<?> findById(int id){
        return productRepo.findById(id);
    }

    public void deleteProduct(ProductEntity product){
        productRepo.delete(product);
    }





}
