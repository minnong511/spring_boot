package com.sk.skala.myapp.myapp.dto;

import com.sk.skala.myapp.myapp.domain.ProductStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductResponse {

    private Long id;
    private String name;
    private Integer price;
    private Integer stockQuantity;
    private ProductStatus status;
    private String description;
    private String displayLabel;  // @Transient 필드 — 런타임 계산값 노출
}

// 클라이언트에게 반환할 상품 형태 