package com.basmaonlinestore.productsserver.controllers;
import com.basmaonlinestore.productsserver.models.Category;
import com.basmaonlinestore.productsserver.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public  CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<Categories>> getAllCategories(){
        return ResponseEntity.status(200).body(categoryService.getAllCategories());
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<Categories> getOneCategory(@PathVariable(name = "idCategory") Long id){
        return ResponseEntity.status(200).body(categoryService.getOneCategory(id));
    }

    @PostMapping("")
    public  ResponseEntity<Categories> addCategory(@RequestBody Categories categories){
        return ResponseEntity.status(200).body(categoryService.addCategory(categories));
    }

    @PutMapping("")
    public  ResponseEntity<Categories> updateCategory(@RequestBody Categories categories){
        return ResponseEntity.status(200).body(categoryService.updateCategory(categories));
    }

    @DeleteMapping("")
    public ResponseEntity deleteCategory(@RequestBody Long id){
        return ResponseEntity.status(200).body(categoryService.deleteCategory(id));
    }
}