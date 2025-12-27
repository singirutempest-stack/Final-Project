package kz.project.shop.service.impl;

import kz.project.shop.dto.request.CartItemAddRequest;
import kz.project.shop.dto.response.CartResponse;
import kz.project.shop.entity.Cart;
import kz.project.shop.entity.Product;
import kz.project.shop.entity.User;
import kz.project.shop.mapper.CartMapper;
import kz.project.shop.repository.CartRepository;
import kz.project.shop.repository.ProductRepository;
import kz.project.shop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {

    @Mock CartRepository cartRepository;
    @Mock UserRepository userRepository;
    @Mock ProductRepository productRepository;
    @Mock CartMapper cartMapper;

    @InjectMocks
    CartServiceImpl cartService;

    @Test
    void getByUser_shouldCreateCartIfNotExists() {
        User user = new User();
        Cart cart = new Cart();
        cart.setUser(user);

        when(cartRepository.findByUserId(1L)).thenReturn(Optional.empty());
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(cartRepository.save(any())).thenReturn(cart);
        when(cartMapper.toResponse(any())).thenReturn(new CartResponse());

        CartResponse response = cartService.getByUser(1L);

        assertNotNull(response);
        verify(cartRepository).save(any());
    }

    @Test
    void addItem_shouldAddProductToCart() {
        Cart cart = new Cart();
        Product product = new Product();

        CartItemAddRequest request = new CartItemAddRequest();
        request.setProductId(1L);
        request.setQuantity(2);

        when(cartRepository.findByUserId(1L)).thenReturn(Optional.of(cart));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(cartRepository.save(any())).thenReturn(cart);
        when(cartMapper.toResponse(any())).thenReturn(new CartResponse());

        CartResponse response = cartService.addItem(1L, request);

        assertNotNull(response);
        verify(cartRepository).save(cart);
    }
}
