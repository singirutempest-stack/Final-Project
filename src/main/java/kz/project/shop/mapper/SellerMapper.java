package kz.project.shop.mapper;

import kz.project.shop.dto.response.SellerResponse;
import kz.project.shop.entity.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    @Mapping(target = "userId", source = "user.id")
    SellerResponse toResponse(Seller seller);
}
