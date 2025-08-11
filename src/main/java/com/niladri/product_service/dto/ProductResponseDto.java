package com.niladri.product_service.dto;

import com.niladri.product_service.entity.COLORS;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponseDto {
    private String title;
    private COLORS color;
    private Float price;
    private String description;
    private Float discount;
    private String model;
    private Integer stock;
    private Long category_id;
}
