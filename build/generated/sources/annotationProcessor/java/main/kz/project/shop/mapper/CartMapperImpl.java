package kz.project.shop.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.project.shop.dto.response.CartItemResponse;
import kz.project.shop.dto.response.CartResponse;
import kz.project.shop.entity.Cart;
import kz.project.shop.entity.CartItem;
import kz.project.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class CartMapperImpl implements CartMapper {

    @Autowired
    private CartItemMapper cartItemMapper;

    @Override
    public CartResponse toResponse(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartResponse cartResponse = new CartResponse();

        cartResponse.setUserId( cartUserId( cart ) );
        cartResponse.setId( cart.getId() );
        cartResponse.setItems( cartItemListToCartItemResponseList( cart.getItems() ) );

        return cartResponse;
    }

    private Long cartUserId(Cart cart) {
        if ( cart == null ) {
            return null;
        }
        User user = cart.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<CartItemResponse> cartItemListToCartItemResponseList(List<CartItem> list) {
        if ( list == null ) {
            return null;
        }

        List<CartItemResponse> list1 = new ArrayList<CartItemResponse>( list.size() );
        for ( CartItem cartItem : list ) {
            list1.add( cartItemMapper.toResponse( cartItem ) );
        }

        return list1;
    }
}
