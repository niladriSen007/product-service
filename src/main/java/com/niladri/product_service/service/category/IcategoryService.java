package com.niladri.product_service.service.category;

import com.niladri.product_service.dto.CategoryDto;
import com.niladri.product_service.dto.CategoryResponseDto;

import java.util.List;

public interface IcategoryService {
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto addCategory(CategoryDto category);
    CategoryResponseDto getCategoryById(Long categoryId);
    CategoryResponseDto updateCategory(Long categoryId, CategoryDto category);
    void deleteCategory(Long categoryId);
}
