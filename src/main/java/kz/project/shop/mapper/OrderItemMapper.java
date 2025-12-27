package kz.project.shop.mapper;

import kz.project.shop.dto.response.OrderItemResponse;
import kz.project.shop.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(target = "productName", source = "product.name")
    OrderItemResponse toResponse(OrderItem item);
}
