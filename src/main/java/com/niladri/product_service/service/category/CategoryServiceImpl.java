package com.niladri.product_service.service.category;

import com.niladri.product_service.dto.CategoryDto;
import com.niladri.product_service.dto.CategoryResponseDto;
import com.niladri.product_service.entity.Category;
import com.niladri.product_service.exceptions.CategoryAlreadyExists;
import com.niladri.product_service.exceptions.CategoryNotFound;
import com.niladri.product_service.mapper.ModelMapper;
import com.niladri.product_service.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements IcategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return categoryRepo.findAll()
                .stream()
                .map(ModelMapper::mapToCategoryResponseDto)
                .toList();
    }

    @Override
    public CategoryResponseDto addCategory(CategoryDto category) {

        Category categoryToBeAdded = ModelMapper.mapToCategory(category);

        //If a category exists in the dictionary
        if (categoryRepo.existsByName(categoryToBeAdded.getName())) {
            throw new CategoryAlreadyExists("Category already exists");
        }
        return ModelMapper.mapToCategoryResponseDto(categoryRepo.save(categoryToBeAdded));
    }

    @Override
    public CategoryResponseDto getCategoryById(Long categoryId) {

        //Check if the category exists in the database or not
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFound("Category with id: " + categoryId + " not found"));


        return ModelMapper.mapToCategoryResponseDto(category);

    }

    @Override
    public CategoryResponseDto updateCategory(Long categoryId, CategoryDto category) {

        //Check if the category exists in the database or not
        Category categoryToBeUpdated = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFound("Category with id: " + categoryId + " not found"));

        categoryToBeUpdated.setName(category.getName());

        return ModelMapper.mapToCategoryResponseDto(categoryRepo.save(categoryToBeUpdated));
    }

    @Override
    public void deleteCategory(Long categoryId) {
            //Check if the category exists in the database or not
            Category category = categoryRepo.findById(categoryId)
                    .orElseThrow(() -> new CategoryNotFound("Category with id: " + categoryId + " not found"));
            categoryRepo.delete(category);
    }



}
