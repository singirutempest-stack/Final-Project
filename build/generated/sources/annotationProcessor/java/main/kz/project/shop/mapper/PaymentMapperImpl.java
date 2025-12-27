package kz.project.shop.mapper;

import javax.annotation.processing.Generated;
import kz.project.shop.dto.response.PaymentResponse;
import kz.project.shop.entity.Payment;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentResponse toResponse(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentResponse paymentResponse = new PaymentResponse();

        paymentResponse.setId( payment.getId() );
        paymentResponse.setStatus( payment.getStatus() );
        paymentResponse.setPaidAt( payment.getPaidAt() );

        return paymentResponse;
    }
}
