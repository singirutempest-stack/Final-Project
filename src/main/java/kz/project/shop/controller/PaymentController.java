//package kz.project.shop.controller;
//
//import kz.project.shop.dto.request.PaymentRequest;
//import kz.project.shop.dto.response.PaymentResponse;
//import kz.project.shop.service.PaymentService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/payments")
//public class PaymentController {
//
//    private final PaymentService paymentService;
//
//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
//
//    @PostMapping
//    public PaymentResponse pay(@RequestBody PaymentRequest request) {
//        return paymentService.pay(request);
//    }
//}





package kz.project.shop.controller;

import kz.project.shop.dto.request.PaymentRequest;
import kz.project.shop.dto.response.PaymentResponse;
import kz.project.shop.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentResponse pay(@RequestBody PaymentRequest request) {
        return paymentService.pay(request);
    }

    @PatchMapping("/{id}/refund")
    public PaymentResponse refund(@PathVariable Long id) {
        return paymentService.refund(id);
    }
}

