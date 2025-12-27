package kz.project.shop.mapper;

import kz.project.shop.dto.request.ProductRequest;
import kz.project.shop.dto.response.ProductResponse;
import kz.project.shop.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "seller", ignore = true)
    Product toEntity(ProductRequest request);

    @Mapping(target = "categoryName", source = "category.name")
    ProductResponse toResponse(Product product);
}
