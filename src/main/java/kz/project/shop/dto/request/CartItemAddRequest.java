package kz.project.shop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemAddRequest {
    private Long productId;
    private int quantity;
}
