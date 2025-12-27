package kz.project.shop.service;

import kz.project.shop.dto.request.PaymentRequest;
import kz.project.shop.dto.response.PaymentResponse;

public interface PaymentService {

    PaymentResponse pay(PaymentRequest request);

    PaymentResponse refund(Long paymentId);
}
