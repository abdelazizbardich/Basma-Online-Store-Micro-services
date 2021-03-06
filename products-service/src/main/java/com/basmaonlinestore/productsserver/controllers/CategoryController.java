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
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.status(200).body(categoryService.getAllCategories());
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<Category> getOneCategory(@PathVariable(name = "idCategory") Long id){
        return ResponseEntity.status(200).body(categoryService.getOneCategory(id));
    }

    @PostMapping("")
    public  ResponseEntity<Category> addCategory(@RequestBody Category category){
        return ResponseEntity.status(200).body(categoryService.addCategory(category));
    }

    @PutMapping("")
    public  ResponseEntity<Category> updateCategory(@RequestBody Category category){
        return ResponseEntity.status(200).body(categoryService.updateCategory(category));
    }

    @DeleteMapping("")
    public ResponseEntity deleteCategory(@RequestBody Category category){
        return ResponseEntity.status(200).body(categoryService.deleteCategory(category.getIdCategory()));
    }
}