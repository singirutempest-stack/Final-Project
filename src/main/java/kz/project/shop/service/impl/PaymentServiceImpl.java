package kz.project.shop.service.impl;

import kz.project.shop.dto.request.PaymentRequest;
import kz.project.shop.dto.response.PaymentResponse;
import kz.project.shop.entity.Order;
import kz.project.shop.entity.Payment;
import kz.project.shop.mapper.PaymentMapper;
import kz.project.shop.repository.OrderRepository;
import kz.project.shop.repository.PaymentRepository;
import kz.project.shop.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              OrderRepository orderRepository,
                              PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentResponse pay(PaymentRequest request) {
        Order order = orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(request.getAmount());
        payment.setStatus("PAID");
        payment.setPaidAt(LocalDateTime.now());

        return paymentMapper.toResponse(paymentRepository.save(payment));
    }

    @Override
    public PaymentResponse refund(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("Payment not found"));

        payment.setStatus("REFUNDED");
        return paymentMapper.toResponse(paymentRepository.save(payment));
    }
}
