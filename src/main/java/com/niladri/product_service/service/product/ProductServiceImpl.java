package com.niladri.product_service.service.product;

import com.niladri.product_service.dto.ProductDto;
import com.niladri.product_service.dto.ProductResponseDto;
import com.niladri.product_service.entity.Category;
import com.niladri.product_service.entity.Product;
import com.niladri.product_service.exceptions.CategoryNotFound;
import com.niladri.product_service.exceptions.ProductAlreadyExists;
import com.niladri.product_service.mapper.ModelMapper;
import com.niladri.product_service.repository.CategoryRepo;
import com.niladri.product_service.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IproductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(ModelMapper::mapToProductResponseDto).toList();
    }

    @Override
    public ProductResponseDto addProduct(ProductDto product) {

        //Check if the category exists in the database or not
        Category category = categoryRepo.findById(product.getCategory_id())
                .orElseThrow(() -> new CategoryNotFound("Category not found"));

        //Check if the product with the same name exists in the database or not
        if (productRepo.existsByTitle(product.getTitle())) {
            throw new ProductAlreadyExists("Product with the same name already exists");
        }

        Product product1 = ModelMapper.mapToProduct(product);
        product1.setCategory(category);
        return ModelMapper.mapToProductResponseDto(productRepo.save(product1));

    }


}
