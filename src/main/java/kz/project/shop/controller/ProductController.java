//package kz.project.shop.controller;
//
//import kz.project.shop.dto.request.ProductRequest;
//import kz.project.shop.dto.response.ProductResponse;
//import kz.project.shop.service.ProductService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//
//    private final ProductService productService;
//
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @PostMapping
//    public ProductResponse create(@RequestBody ProductRequest request) {
//        return productService.create(request);
//    }
//
//    @GetMapping
//    public List<ProductResponse> getAll() {
//        return productService.getAll();
//    }
//}




package kz.project.shop.controller;

import kz.project.shop.dto.request.ProductRequest;
import kz.project.shop.dto.response.ProductResponse;
import kz.project.shop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        return productService.create(request);
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAll();
    }
    @PutMapping("/{id}")
    public ProductResponse update(
            @PathVariable Long id,
            @RequestBody ProductRequest request
    ) {
        return productService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

