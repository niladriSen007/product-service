package com.niladri.product_service.controller;

import com.niladri.product_service.dto.ProductDto;
import com.niladri.product_service.dto.ProductResponseDto;
import com.niladri.product_service.service.product.IproductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final IproductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/")
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductDto product) {
        log.info("Product added: {}", product);
        return ResponseEntity.ok(productService.addProduct(product));
    }
}
