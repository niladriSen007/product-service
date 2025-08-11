package com.niladri.product_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {

    private String image_url;
    @Size(min = 1, max = 50)
    @Column(name = "prod_title", nullable = false, unique = true)
    private String title;
    @Column(name = "prod_color", nullable = false)
    @Enumerated(EnumType.STRING)
    private COLORS color;
    @Column(name = "prod_price", nullable = false)
    private Float price;
    @Column(name = "prod_description", nullable = false)
    private String description;
    @Column(name = "prod_discount", nullable = false)
    private Float discount;
    @Column(name = "prod_model", nullable = false)
    private String model;
    @Column(name = "prod_stock", nullable = false)
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_category_id", nullable = false)
    private Category category;
}
