package kz.project.shop.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kz.project.shop.dto.response.OrderItemResponse;
import kz.project.shop.dto.response.OrderResponse;
import kz.project.shop.entity.Order;
import kz.project.shop.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public OrderResponse toResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setId( order.getId() );
        orderResponse.setCreatedAt( order.getCreatedAt() );
        orderResponse.setStatus( order.getStatus() );
        orderResponse.setItems( orderItemListToOrderItemResponseList( order.getItems() ) );

        return orderResponse;
    }

    protected List<OrderItemResponse> orderItemListToOrderItemResponseList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemResponse> list1 = new ArrayList<OrderItemResponse>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemMapper.toResponse( orderItem ) );
        }

        return list1;
    }
}
