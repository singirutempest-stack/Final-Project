//package kz.project.shop.controller;
//
//import kz.project.shop.dto.response.OrderResponse;
//import kz.project.shop.service.OrderService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/orders")
//public class OrderController {
//
//    private final OrderService orderService;
//
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    @PostMapping("/{userId}")
//    public OrderResponse create(@PathVariable Long userId) {
//        return orderService.create(userId);
//    }
//}


package kz.project.shop.controller;

import kz.project.shop.dto.response.OrderResponse;
import kz.project.shop.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{userId}")
    public OrderResponse create(@PathVariable Long userId) {
        return orderService.create(userId);
    }

    @PatchMapping("/{id}/cancel")
    public OrderResponse cancel(@PathVariable Long id) {
        return orderService.cancel(id);
    }
}
