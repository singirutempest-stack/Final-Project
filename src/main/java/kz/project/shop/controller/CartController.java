//package kz.project.shop.controller;
//
//import kz.project.shop.dto.request.CartItemAddRequest;
//import kz.project.shop.dto.response.CartResponse;
//import kz.project.shop.service.CartService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/cart")
//public class CartController {
//
//    private final CartService cartService;
//
//    public CartController(CartService cartService) {
//        this.cartService = cartService;
//    }
//
//    @GetMapping("/{userId}")
//    public CartResponse get(@PathVariable Long userId) {
//        return cartService.getByUser(userId);
//    }
//
//    @PostMapping("/{userId}/items")
//    public CartResponse addItem(
//            @PathVariable Long userId,
//            @RequestBody CartItemAddRequest request
//    ) {
//        return cartService.addItem(userId, request);
//    }
//}



package kz.project.shop.controller;

import kz.project.shop.dto.request.CartItemAddRequest;
import kz.project.shop.dto.response.CartResponse;
import kz.project.shop.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public CartResponse get(@PathVariable Long userId) {
        return cartService.getByUser(userId);
    }

    @PostMapping("/{userId}/items")
    public CartResponse addItem(
            @PathVariable Long userId,
            @RequestBody CartItemAddRequest request
    ) {
        return cartService.addItem(userId, request);
    }

    @DeleteMapping("/{userId}/items/{productId}")
    public CartResponse removeItem(
            @PathVariable Long userId,
            @PathVariable Long productId
    ) {
        return cartService.removeItem(userId, productId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> clear(@PathVariable Long userId) {
        cartService.clear(userId);
        return ResponseEntity.noContent().build();
    }
}
