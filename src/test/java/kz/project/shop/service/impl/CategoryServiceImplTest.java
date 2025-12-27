package kz.project.shop.service.impl;

import kz.project.shop.dto.request.CategoryRequest;
import kz.project.shop.dto.response.CategoryResponse;
import kz.project.shop.entity.Category;
import kz.project.shop.mapper.CategoryMapper;
import kz.project.shop.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock CategoryRepository categoryRepository;
    @Mock CategoryMapper categoryMapper;

    @InjectMocks
    CategoryServiceImpl categoryService;

    @Test
    void create_shouldSaveCategory() {
        when(categoryMapper.toEntity(any())).thenReturn(new Category());
        when(categoryRepository.save(any())).thenReturn(new Category());
        when(categoryMapper.toResponse(any())).thenReturn(new CategoryResponse());

        CategoryResponse response = categoryService.create(new CategoryRequest());

        assertNotNull(response);
    }
}
