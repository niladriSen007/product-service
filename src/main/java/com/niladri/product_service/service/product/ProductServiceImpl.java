package com.niladri.product_service.service.product;

import com.niladri.product_service.dto.ProductDto;
import com.niladri.product_service.dto.ProductResponseDto;
import com.niladri.product_service.entity.Category;
import com.niladri.product_service.entity.Product;
import com.niladri.product_service.exceptions.CategoryNotFound;
import com.niladri.product_service.exceptions.ProductAlreadyExists;
import com.niladri.product_service.exceptions.ProductNotFound;
import com.niladri.product_service.mapper.ModelMapper;
import com.niladri.product_service.repository.CategoryRepo;
import com.niladri.product_service.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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

        //Check if the product with the same name and same category exists in the database or not
        if (productRepo.existsByTitleAndCategory_Id(product.getTitle(), product.getCategory_id())) {
            throw new ProductAlreadyExists("Product with the same name already exists");
        }

        Product product1 = ModelMapper.mapToProduct(product);
        product1.setCategory(category);
        return ModelMapper.mapToProductResponseDto(productRepo.save(product1));

    }

    @Override
    public ProductResponseDto getProductById(Long productId) {

        Product product = productRepo.findById(productId).orElseThrow(() -> new ProductNotFound("Product not found"));
        return ModelMapper.mapToProductResponseDto(product);
    }

    @Override
    public ProductResponseDto updateProduct(Long productId, ProductDto product) {

        //check if the product exists in the database or not
        Product productToBeUpdated = productRepo.findById
                (productId).orElseThrow(() -> new ProductNotFound("Product not found"));

        //check if the category exists in the database or not
        Category category = categoryRepo.findById(product.getCategory_id())
                .orElseThrow(() -> new CategoryNotFound("Category not found"));
        productToBeUpdated.setCategory(category);

        //check if the product with the same name and same category exists in the database or not
        if (productRepo.existsByTitleAndCategory_Id(product.getTitle(), product.getCategory_id())) {
            throw new ProductAlreadyExists("Product with the same name already exists");
        }


        productToBeUpdated.setTitle(product.getTitle());
        productToBeUpdated.setColor(product.getColor());
        productToBeUpdated.setPrice(product.getPrice());
        productToBeUpdated.setDescription(product.getDescription());
        productToBeUpdated.setDiscount(product.getDiscount());
        productToBeUpdated.setModel(product.getModel());
        productToBeUpdated.setStock(product.getStock());
        Product updatedProduct = productRepo.save(productToBeUpdated);
        return ModelMapper.mapToProductResponseDto(productRepo.save(productToBeUpdated));
    }


}
