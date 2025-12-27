package kz.project.shop.mapper;

import javax.annotation.processing.Generated;
import kz.project.shop.dto.response.OrderItemResponse;
import kz.project.shop.entity.OrderItem;
import kz.project.shop.entity.Product;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemResponse toResponse(OrderItem item) {
        if ( item == null ) {
            return null;
        }

        OrderItemResponse orderItemResponse = new OrderItemResponse();

        orderItemResponse.setProductName( itemProductName( item ) );
        orderItemResponse.setQuantity( item.getQuantity() );
        orderItemResponse.setPriceAtPurchase( item.getPriceAtPurchase() );

        return orderItemResponse;
    }

    private String itemProductName(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        Product product = orderItem.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
