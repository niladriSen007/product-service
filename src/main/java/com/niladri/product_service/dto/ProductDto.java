package com.niladri.product_service.dto;

import com.niladri.product_service.entity.COLORS;
import com.niladri.product_service.validations.ColorSchemaValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String image_url;

    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 50,message = "Title must be between 1 and 50 characters")
    private String title;

    @NotBlank
    @ColorSchemaValidation(message = "Invalid value for the product color field.")
    private COLORS color;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "1",message = "Price must be at least 1")
    @Digits(integer = 10,fraction = 2,message = "Price must be a number with up to 2 decimal places")
    private Float price;

    @NotBlank(message = "Description is required")
    @Size(min = 1,max = 1000,message = "Description must be between 1 and 1000 characters")
    private String description;

    @NotNull(message = "Discount is required")
    @DecimalMin(value = "0",message = "Discount must be at least 0")
    @Digits(integer = 10,fraction = 2,message = "Discount must be a number with up to 2 decimal places")
    private Float discount;

    @NotBlank(message = "Model is required")
    @Size(min = 1,max = 50,message = "Model must be between 1 and 50 characters")
    private String model;

    @NotNull(message = "Stock is required")
    @Min(value = 0,message = "Stock can not be negative")
    private Integer stock;

    @NotNull(message = "Category is required")
    @Min(value = 1,message = "Category can not be negative")
    private Long category_id;
}
