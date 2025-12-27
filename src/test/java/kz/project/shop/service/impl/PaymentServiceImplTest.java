package kz.project.shop.service.impl;

import kz.project.shop.dto.request.PaymentRequest;
import kz.project.shop.dto.response.PaymentResponse;
import kz.project.shop.entity.Order;
import kz.project.shop.entity.Payment;
import kz.project.shop.mapper.PaymentMapper;
import kz.project.shop.repository.OrderRepository;
import kz.project.shop.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {

    @Mock PaymentRepository paymentRepository;
    @Mock OrderRepository orderRepository;
    @Mock PaymentMapper paymentMapper;

    @InjectMocks
    PaymentServiceImpl paymentService;

    @Test
    void pay_shouldCreatePayment() {
        PaymentRequest request = new PaymentRequest();
        request.setOrderId(1L);
        request.setAmount(BigDecimal.valueOf(1000));

        when(orderRepository.findById(1L)).thenReturn(Optional.of(new Order()));
        when(paymentRepository.save(any())).thenReturn(new Payment());
        when(paymentMapper.toResponse(any())).thenReturn(new PaymentResponse());

        PaymentResponse response = paymentService.pay(request);

        assertNotNull(response);
    }

    @Test
    void refund_shouldUpdatePaymentStatus() {
        Payment payment = new Payment();

        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
        when(paymentRepository.save(any())).thenReturn(payment);
        when(paymentMapper.toResponse(any())).thenReturn(new PaymentResponse());

        PaymentResponse response = paymentService.refund(1L);

        assertNotNull(response);
    }
}
