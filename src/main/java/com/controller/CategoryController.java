package com.controller;

import com.data.CategoryRepository;
import com.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return categoryRepository.findById(id).get();
    }

    @GetMapping()
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

//    @GetMapping("/name/{name}")
//    public String getCategoryByName(@PathVariable("name") String name) {
//        if(categoryRepository.findByName(name).size() > 0) {
//            System.out.println(categoryRepository.findByName(name));
//            return "yes";
//        } else {
//            return "no";
//        }
//    }

    @PostMapping()
    public Category addCategory (@RequestBody Category category) {
        category.setName(category.getName().toLowerCase());

        if(categoryRepository.findByName(category.getName()).size() == 0) {
            return categoryRepository.save(category);
        } else {
            return categoryRepository.findByName(category.getName()).get(0);
        }
    }

}
