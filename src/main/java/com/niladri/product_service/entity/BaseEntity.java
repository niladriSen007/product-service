package com.niladri.product_service.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;


    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;


    @LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;


    @PrePersist
    protected void onCreation() {
        createdAt = Instant.now();
        updatedAt = Instant.now();

    }

    @PreUpdate
    protected void onUpdation() {
        updatedAt = Instant.now();
    }
}
