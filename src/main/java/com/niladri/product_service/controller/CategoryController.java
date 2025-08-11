package com.niladri.product_service.controller;

import com.niladri.product_service.dto.CategoryDto;
import com.niladri.product_service.dto.CategoryResponseDto;
import com.niladri.product_service.service.category.IcategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final IcategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryDto category) {
        log.info("Category added: {}", category);
        return ResponseEntity.ok(categoryService.addCategory(category));
    }
}
