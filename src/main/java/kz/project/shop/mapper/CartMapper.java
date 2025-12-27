package kz.project.shop.mapper;

import kz.project.shop.dto.response.CartResponse;
import kz.project.shop.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CartItemMapper.class)
public interface CartMapper {

    @Mapping(target = "userId", source = "user.id")
    CartResponse toResponse(Cart cart);
}
