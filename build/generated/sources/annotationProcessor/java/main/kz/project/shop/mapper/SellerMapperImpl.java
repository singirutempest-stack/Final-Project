package kz.project.shop.mapper;

import javax.annotation.processing.Generated;
import kz.project.shop.dto.response.SellerResponse;
import kz.project.shop.entity.Seller;
import kz.project.shop.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class SellerMapperImpl implements SellerMapper {

    @Override
    public SellerResponse toResponse(Seller seller) {
        if ( seller == null ) {
            return null;
        }

        SellerResponse sellerResponse = new SellerResponse();

        sellerResponse.setUserId( sellerUserId( seller ) );
        sellerResponse.setId( seller.getId() );
        sellerResponse.setActive( seller.isActive() );

        return sellerResponse;
    }

    private Long sellerUserId(Seller seller) {
        if ( seller == null ) {
            return null;
        }
        User user = seller.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
