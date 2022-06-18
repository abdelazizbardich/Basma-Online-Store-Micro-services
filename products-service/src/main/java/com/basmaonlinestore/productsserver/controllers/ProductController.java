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
    public ResponseEntity<List<Products>> getAllProducts(){
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Products> getOneProduct(@PathVariable(name = "idProduct") Long id){
        return ResponseEntity.status(200).body(productService.getOneProduct(id));
    }

    @PostMapping("")
    public  ResponseEntity<Products> addProduct(@RequestBody Products products){
        return ResponseEntity.status(200).body(ProductService.addProduct(products));
    }

    @PutMapping("")
    public  ResponseEntity<Products> updateProduct(@RequestBody Products products){
        return ResponseEntity.status(200).body(ProductService.updateProduct(products));
    }

    @DeleteMapping("")
    public ResponseEntity deleteProduct(@RequestBody Long id){
        return ResponseEntity.status(200).body(ProductService.deleteProduct(id));
    }
}