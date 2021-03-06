package com.basmaonlinestore.productsserver.services;

import com.basmaonlinestore.productsserver.models.Category;
import com.basmaonlinestore.productsserver.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    public List<Category> getAllCategories(){
        try {
            return categoryRepository.findAll();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Category getOneCategory(Long id){
        try {
            return categoryRepository.findById(id).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Category addCategory( Category category){
        try {
            return categoryRepository.save(category);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Category updateCategory(Category category){
        try {
            return categoryRepository.save(category);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Boolean deleteCategory(Long id){
        try {
            categoryRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

}