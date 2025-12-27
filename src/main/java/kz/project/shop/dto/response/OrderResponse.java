package kz.project.shop.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private LocalDateTime createdAt;
    private String status;
    private List<OrderItemResponse> items;
}
