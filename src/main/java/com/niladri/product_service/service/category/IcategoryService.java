package com.niladri.product_service.service.category;

import com.niladri.product_service.dto.CategoryDto;
import com.niladri.product_service.dto.CategoryResponseDto;

public interface IcategoryService {
//    CategoryResponseDto getAllCategories();
    CategoryResponseDto addCategory(CategoryDto category);
}
