
package kz.project.shop.service.impl;

import kz.project.shop.dto.request.CartItemAddRequest;
import kz.project.shop.dto.response.CartResponse;
import kz.project.shop.entity.Cart;
import kz.project.shop.entity.Product;
import kz.project.shop.mapper.CartMapper;
import kz.project.shop.repository.CartRepository;
import kz.project.shop.repository.ProductRepository;
import kz.project.shop.repository.UserRepository;
import kz.project.shop.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository,
                           UserRepository userRepository,
                           ProductRepository productRepository,
                           CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public CartResponse getByUser(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart c = new Cart();
                    c.setUser(userRepository.findById(userId)
                            .orElseThrow(() -> new IllegalArgumentException("User not found")));
                    return cartRepository.save(c);
                });

        return cartMapper.toResponse(cart);
    }

    @Override
    public CartResponse addItem(Long userId, CartItemAddRequest request) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        cart.addProduct(product, request.getQuantity());
        return cartMapper.toResponse(cartRepository.save(cart));
    }

    @Override
    public CartResponse removeItem(Long userId, Long productId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        cart.getItems().removeIf(item ->
                item.getProduct() != null
                        && item.getProduct().getId() != null
                        && item.getProduct().getId().equals(productId)
        );

        return cartMapper.toResponse(cartRepository.save(cart));
    }

    @Override
    public void clear(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
