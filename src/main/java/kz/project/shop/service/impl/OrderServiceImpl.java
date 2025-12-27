

package kz.project.shop.service.impl;

import kz.project.shop.dto.response.OrderResponse;
import kz.project.shop.entity.Cart;
import kz.project.shop.entity.Order;
import kz.project.shop.entity.OrderItem;
import kz.project.shop.mapper.OrderMapper;
import kz.project.shop.repository.CartRepository;
import kz.project.shop.repository.OrderRepository;
import kz.project.shop.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository,
                            CartRepository cartRepository,
                            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponse create(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        Order order = new Order();
        order.setUser(cart.getUser());
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("CREATED");

        cart.getItems().forEach(item -> {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(item.getProduct());
            oi.setQuantity(item.getQuantity());
            oi.setPriceAtPurchase(item.getProduct().getPrice());
            order.getItems().add(oi);
        });

        cart.getItems().clear();
        cartRepository.save(cart);

        return orderMapper.toResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse cancel(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        order.setStatus("CANCELED");
        return orderMapper.toResponse(orderRepository.save(order));
    }
}
