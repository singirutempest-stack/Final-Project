//package kz.project.shop.controller;
//
//import kz.project.shop.dto.request.CategoryRequest;
//import kz.project.shop.dto.response.CategoryResponse;
//import kz.project.shop.service.CategoryService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/categories")
//public class CategoryController {
//
//    private final CategoryService categoryService;
//
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @PostMapping
//    public CategoryResponse create(@RequestBody CategoryRequest request) {
//        return categoryService.create(request);
//    }
//
//    @GetMapping
//    public List<CategoryResponse> getAll() {
//        return categoryService.getAll();
//    }
//    @PutMapping("/{id}")
//    public CategoryResponse update(
//            @PathVariable Long id,
//            @RequestBody CategoryRequest request
//    ) {
//        return categoryService.update(id, request);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        categoryService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}




package kz.project.shop.controller;

import kz.project.shop.dto.request.CategoryRequest;
import kz.project.shop.dto.response.CategoryResponse;
import kz.project.shop.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponse create(@RequestBody CategoryRequest request) {
        return categoryService.create(request);
    }

    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryService.getAll();
    }
    @PutMapping("/{id}")
    public CategoryResponse update(
            @PathVariable Long id,
            @RequestBody CategoryRequest request
    ) {
        return categoryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
