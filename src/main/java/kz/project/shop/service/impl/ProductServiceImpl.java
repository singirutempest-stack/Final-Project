
package kz.project.shop.service.impl;

import kz.project.shop.dto.request.ProductRequest;
import kz.project.shop.dto.response.ProductResponse;
import kz.project.shop.entity.Product;
import kz.project.shop.mapper.ProductMapper;
import kz.project.shop.repository.CategoryRepository;
import kz.project.shop.repository.ProductRepository;
import kz.project.shop.repository.SellerRepository;
import kz.project.shop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SellerRepository sellerRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              SellerRepository sellerRepository,
                              ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.sellerRepository = sellerRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.toEntity(request);

        product.setCategory(
                categoryRepository.findById(request.getCategoryId())
                        .orElseThrow(() -> new IllegalArgumentException("Category not found"))
        );

        product.setSeller(
                sellerRepository.findById(request.getSellerId())
                        .orElseThrow(() -> new IllegalArgumentException("Seller not found"))
        );

        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());

        product.setCategory(
                categoryRepository.findById(request.getCategoryId())
                        .orElseThrow(() -> new IllegalArgumentException("Category not found"))
        );

        product.setSeller(
                sellerRepository.findById(request.getSellerId())
                        .orElseThrow(() -> new IllegalArgumentException("Seller not found"))
        );

        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }
}
