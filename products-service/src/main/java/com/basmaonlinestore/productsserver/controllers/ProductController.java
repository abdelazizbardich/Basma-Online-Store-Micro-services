package com.basmaonlinestore.productsserver.controllers;
import com.basmaonlinestore.productsserver.models.Product;
import com.basmaonlinestore.productsserver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public  ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Product> getOneProduct(@PathVariable(name = "idProduct") Long id){
        return ResponseEntity.status(200).body(productService.getOneProduct(id));
    }

    @PostMapping("")
    public  ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.status(200).body(productService.addProduct(product));
    }

    @PutMapping("")
    public  ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return ResponseEntity.status(200).body(productService.updateProduct(product));
    }

    @DeleteMapping("")
    public ResponseEntity deleteProduct(@RequestBody Product product){
        return ResponseEntity.status(200).body(productService.deleteProduct(product.getIdProduct()));
    }
}