package com.niladri.product_service.service.category;

import com.niladri.product_service.dto.CategoryDto;
import com.niladri.product_service.dto.CategoryResponseDto;
import com.niladri.product_service.entity.Category;
import com.niladri.product_service.exceptions.CategoryAlreadyExists;
import com.niladri.product_service.mapper.ModelMapper;
import com.niladri.product_service.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements IcategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public CategoryResponseDto addCategory(CategoryDto category) {

        Category categoryToBeAdded = ModelMapper.mapToCategory(category);

        //If a category exists in the dictionary
        if (categoryRepo.existsByName(categoryToBeAdded.getName())) {
            throw new CategoryAlreadyExists("Category already exists");
        }
        return ModelMapper.mapToCategoryDto(categoryRepo.save(categoryToBeAdded));
    }
}
