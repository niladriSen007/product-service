package com.niladri.product_service.repository;

import com.niladri.product_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}
