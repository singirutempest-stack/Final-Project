package kz.project.shop.mapper;

import javax.annotation.processing.Generated;
import kz.project.shop.dto.request.CategoryRequest;
import kz.project.shop.dto.response.CategoryResponse;
import kz.project.shop.entity.Category;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( request.getName() );
        category.setDescription( request.getDescription() );

        return category;
    }

    @Override
    public CategoryResponse toResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId( category.getId() );
        categoryResponse.setName( category.getName() );
        categoryResponse.setDescription( category.getDescription() );

        return categoryResponse;
    }
}
