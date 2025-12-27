package kz.project.shop.mapper;

import javax.annotation.processing.Generated;
import kz.project.shop.dto.request.RoleRequest;
import kz.project.shop.dto.response.RoleResponse;
import kz.project.shop.entity.Role;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleRequest request) {
        if ( request == null ) {
            return null;
        }

        Role role = new Role();

        role.setName( request.getName() );

        return role;
    }

    @Override
    public RoleResponse toResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setId( role.getId() );
        roleResponse.setName( role.getName() );

        return roleResponse;
    }
}
