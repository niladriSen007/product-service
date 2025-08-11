package com.niladri.product_service.advice;

import com.niladri.product_service.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ApiResponse<?>> handleProductNotFound(ProductNotFound e) {
        return buildErrorResponseEntity(ApiError.builder().status(HttpStatus.NOT_FOUND).message(e.getMessage()).build());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e) {
        return buildErrorResponseEntity(ApiError.builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage()).build());
    }


    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }
}
