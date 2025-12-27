package kz.project.shop.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentResponse {
    private Long id;
    private String status;
    private LocalDateTime paidAt;
}
