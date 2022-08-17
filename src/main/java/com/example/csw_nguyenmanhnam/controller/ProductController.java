package com.example.csw_nguyenmanhnam.controller;

import com.example.csw_nguyenmanhnam.entity.ProductEntity;
import com.example.csw_nguyenmanhnam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController

public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/index")
    public ResponseEntity<List<ProductEntity>> index(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductEntity product){
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/sellProduct/{id}"})
    public ResponseEntity<ProductEntity> update(@PathVariable int id){
        Optional<ProductEntity> optionalProductEntity = (Optional<ProductEntity>) productService.findById(id);
        if (!optionalProductEntity.isPresent()){
            ResponseEntity.badRequest().build();
        }
        ProductEntity product = optionalProductEntity.get();
        product.setQuantity(product.getQuantity()-1);
        return ResponseEntity.ok(productService.addProduct(product));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id){

        ProductEntity product = (ProductEntity) productService.findById(id)

                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));

        productService.deleteProduct(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
