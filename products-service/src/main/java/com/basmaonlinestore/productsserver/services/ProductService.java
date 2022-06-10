package com.basmaonlinestore.productsserver.services;

import com.basmaonlinestore.productsserver.models.Product;
import com.basmaonlinestore.productsserver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Products> getAllProducts(){
        try {
            return productRepository.findAll();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Products getOneProduct(Long id){
        try {
            return productRepository.findById(id).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Products addProduct( Products products){
        try {
            return productRepository.save(products);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Products updateProduct(Products products){
        try {
            return productRepository.save(products);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Boolean deleteProduct(Long id){
        try {
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

}