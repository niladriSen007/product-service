package com.niladri.product_service.mapper;

import com.niladri.product_service.dto.CategoryDto;
import com.niladri.product_service.dto.CategoryResponseDto;
import com.niladri.product_service.dto.ProductDto;
import com.niladri.product_service.dto.ProductResponseDto;
import com.niladri.product_service.entity.Category;
import com.niladri.product_service.entity.Product;

public class ModelMapper {
    public static ProductResponseDto mapToProductResponseDto(Product product) {
        return ProductResponseDto.builder()
                .title(product.getTitle())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .stock(product.getStock())
                .category_id(product.getCategory().getId())
                .build();
    }

    public static Product mapToProduct(ProductDto productResponseDto) {
        return Product.builder()
                .title(productResponseDto.getTitle())
                .color(productResponseDto.getColor())
                .price(productResponseDto.getPrice())
                .description(productResponseDto.getDescription())
                .discount(productResponseDto.getDiscount())
                .model(productResponseDto.getModel())
                .stock(productResponseDto.getStock())
                .build();
    }

    public static Category mapToCategory(CategoryDto categoryDto) {
        return Category.builder()
                .name(categoryDto.getName())
                .build();
    }

    public static CategoryResponseDto mapToCategoryDto(Category category) {
        return CategoryResponseDto.builder()
                .name(category.getName())
                .build();
    }


}
