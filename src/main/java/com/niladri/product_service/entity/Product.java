package com.niladri.product_service.entity;

import com.niladri.product_service.converter.ColorConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products", uniqueConstraints = @UniqueConstraint(
        columnNames = {
                "prod_title",
                "prod_category_id"
        }
))
public class Product extends BaseEntity {

    private String image_url;
    @Size(min = 1, max = 50)
    @Column(name = "prod_title", nullable = false, unique = true)
    private String title;
    @Column(name = "prod_color", nullable = false)
    @Convert(converter = ColorConverter.class)
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
