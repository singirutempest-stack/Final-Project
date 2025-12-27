package kz.project.shop.service.impl;

import kz.project.shop.dto.request.ProductRequest;
import kz.project.shop.entity.Category;
import kz.project.shop.entity.Product;
import kz.project.shop.entity.Seller;
import kz.project.shop.mapper.ProductMapper;
import kz.project.shop.repository.CategoryRepository;
import kz.project.shop.repository.ProductRepository;
import kz.project.shop.repository.SellerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock ProductRepository productRepository;
    @Mock CategoryRepository categoryRepository;
    @Mock SellerRepository sellerRepository;
    @Mock ProductMapper productMapper;

    @InjectMocks ProductServiceImpl productService;

    @Test
    void create_success() {
        ProductRequest req = new ProductRequest();
        req.setCategoryId(1L);
        req.setSellerId(2L);

        Product product = new Product();

        when(productMapper.toEntity(req)).thenReturn(product);
        when(categoryRepository.findById(1L))
                .thenReturn(Optional.of(new Category()));
        when(sellerRepository.findById(2L))
                .thenReturn(Optional.of(new Seller()));
        when(productRepository.save(product))
                .thenReturn(product);
        when(productMapper.toResponse(product))
                .thenReturn(null);

        assertNotNull(productService.create(req));
    }
}
