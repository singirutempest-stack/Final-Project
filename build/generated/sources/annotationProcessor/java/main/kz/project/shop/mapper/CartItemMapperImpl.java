package kz.project.shop.mapper;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import kz.project.shop.dto.response.CartItemResponse;
import kz.project.shop.entity.CartItem;
import kz.project.shop.entity.Product;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class CartItemMapperImpl implements CartItemMapper {

    @Override
    public CartItemResponse toResponse(CartItem item) {
        if ( item == null ) {
            return null;
        }

        CartItemResponse cartItemResponse = new CartItemResponse();

        cartItemResponse.setProductId( itemProductId( item ) );
        cartItemResponse.setProductName( itemProductName( item ) );
        cartItemResponse.setPrice( itemProductPrice( item ) );
        cartItemResponse.setQuantity( item.getQuantity() );

        return cartItemResponse;
    }

    private Long itemProductId(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product product = cartItem.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String itemProductName(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product product = cartItem.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private BigDecimal itemProductPrice(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Product product = cartItem.getProduct();
        if ( product == null ) {
            return null;
        }
        BigDecimal price = product.getPrice();
        if ( price == null ) {
            return null;
        }
        return price;
    }
}
