package com.niladri.product_service.repository;

import com.niladri.product_service.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    boolean existsByTitle(@NotBlank(message = "Title is required") @Size(min = 1, max = 50, message = "Title must be between 1 and 50 characters") String title);
}
