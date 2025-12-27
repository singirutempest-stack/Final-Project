package kz.project.shop.mapper;

import kz.project.shop.dto.response.OrderResponse;
import kz.project.shop.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = OrderItemMapper.class)
public interface OrderMapper {

    OrderResponse toResponse(Order order);
}
