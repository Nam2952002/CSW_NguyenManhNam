package com.example.csw_nguyenmanhnam.repository;

import com.example.csw_nguyenmanhnam.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
