package kz.project.shop.service;

import kz.project.shop.dto.response.OrderResponse;

public interface OrderService {

    OrderResponse create(Long userId);

    OrderResponse cancel(Long orderId);
}
