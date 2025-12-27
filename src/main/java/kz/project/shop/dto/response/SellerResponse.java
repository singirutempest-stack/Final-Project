package kz.project.shop.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerResponse {
    private Long id;
    private boolean active;
    private Long userId;
}
