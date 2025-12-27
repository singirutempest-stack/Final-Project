package kz.project.shop.mapper;

import javax.annotation.processing.Generated;
import kz.project.shop.dto.request.ProductRequest;
import kz.project.shop.dto.response.ProductResponse;
import kz.project.shop.entity.Category;
import kz.project.shop.entity.Product;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( request.getName() );
        product.setDescription( request.getDescription() );
        product.setPrice( request.getPrice() );
        product.setStockQuantity( request.getStockQuantity() );

        return product;
    }

    @Override
    public ProductResponse toResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setCategoryName( productCategoryName( product ) );
        productResponse.setId( product.getId() );
        productResponse.setName( product.getName() );
        productResponse.setDescription( product.getDescription() );
        productResponse.setPrice( product.getPrice() );
        productResponse.setStockQuantity( product.getStockQuantity() );

        return productResponse;
    }

    private String productCategoryName(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
