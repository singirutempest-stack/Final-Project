package kz.project.shop.mapper;

import kz.project.shop.dto.request.CategoryRequest;
import kz.project.shop.dto.response.CategoryResponse;
import kz.project.shop.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryRequest request);

    CategoryResponse toResponse(Category category);
}
