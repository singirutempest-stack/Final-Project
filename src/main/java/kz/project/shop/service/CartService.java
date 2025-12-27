package kz.project.shop.service;

import kz.project.shop.dto.request.CartItemAddRequest;
import kz.project.shop.dto.response.CartResponse;

public interface CartService {

    CartResponse getByUser(Long userId);

    CartResponse addItem(Long userId, CartItemAddRequest request);

    CartResponse removeItem(Long userId, Long productId);

    void clear(Long userId);
}
