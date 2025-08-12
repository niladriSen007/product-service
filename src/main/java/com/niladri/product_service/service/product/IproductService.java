package com.niladri.product_service.service.product;

import com.niladri.product_service.dto.ProductDto;
import com.niladri.product_service.dto.ProductResponseDto;

import java.util.List;

public interface IproductService {
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto addProduct(ProductDto product);
    ProductResponseDto getProductById(Long productId);
    ProductResponseDto updateProduct(Long productId, ProductDto product);
}
