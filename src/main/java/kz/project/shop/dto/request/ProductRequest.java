package kz.project.shop.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private Long categoryId;
    private Long sellerId;
}
