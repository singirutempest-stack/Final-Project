package kz.project.shop.service.impl;

import kz.project.shop.dto.response.OrderResponse;
import kz.project.shop.entity.Cart;
import kz.project.shop.entity.Order;
import kz.project.shop.mapper.OrderMapper;
import kz.project.shop.repository.CartRepository;
import kz.project.shop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock OrderRepository orderRepository;
    @Mock CartRepository cartRepository;
    @Mock OrderMapper orderMapper;

    @InjectMocks
    OrderServiceImpl orderService;

    @Test
    void create_shouldCreateOrderFromCart() {
        Cart cart = new Cart();

        when(cartRepository.findByUserId(1L)).thenReturn(Optional.of(cart));
        when(orderRepository.save(any())).thenReturn(new Order());
        when(orderMapper.toResponse(any())).thenReturn(new OrderResponse());

        OrderResponse response = orderService.create(1L);

        assertNotNull(response);
        verify(orderRepository).save(any());
    }

    @Test
    void cancel_shouldChangeOrderStatus() {
        Order order = new Order();

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any())).thenReturn(order);
        when(orderMapper.toResponse(any())).thenReturn(new OrderResponse());

        OrderResponse response = orderService.cancel(1L);

        assertNotNull(response);
    }
}
