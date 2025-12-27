package kz.project.shop.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartResponse {
    private Long id;
    private Long userId;
    private List<CartItemResponse> items;
}
