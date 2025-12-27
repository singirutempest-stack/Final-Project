package kz.project.shop.mapper;

import kz.project.shop.dto.response.PaymentResponse;
import kz.project.shop.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentResponse toResponse(Payment payment);
}
