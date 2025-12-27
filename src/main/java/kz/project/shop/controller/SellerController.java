//package kz.project.shop.controller;
//
//import kz.project.shop.dto.response.SellerResponse;
//import kz.project.shop.service.SellerService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/sellers")
//public class SellerController {
//
//    private final SellerService sellerService;
//
//    public SellerController(SellerService sellerService) {
//        this.sellerService = sellerService;
//    }
//
//    @PostMapping("/{userId}")
//    public SellerResponse create(@PathVariable Long userId) {
//        return sellerService.create(userId);
//    }
//
//    @GetMapping("/by-user/{userId}")
//    public SellerResponse getByUser(@PathVariable Long userId) {
//        return sellerService.getByUserId(userId);
//    }
//}




package kz.project.shop.controller;

import kz.project.shop.dto.response.SellerResponse;
import kz.project.shop.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/{userId}")
    public SellerResponse create(@PathVariable Long userId) {
        return sellerService.create(userId);
    }

    @GetMapping("/by-user/{userId}")
    public SellerResponse getByUser(@PathVariable Long userId) {
        return sellerService.getByUserId(userId);
    }
    @PatchMapping("/{id}/deactivate")
    public SellerResponse deactivate(@PathVariable Long id) {
        return sellerService.deactivate(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sellerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
