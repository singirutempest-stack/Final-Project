package kz.project.shop.mapper;

import javax.annotation.processing.Generated;
import kz.project.shop.dto.request.UserCreateRequest;
import kz.project.shop.dto.response.UserResponse;
import kz.project.shop.entity.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-27T06:33:27+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( request.getEmail() );
        user.setPassword( request.getPassword() );

        return user;
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setEmail( user.getEmail() );
        userResponse.setBlocked( user.isBlocked() );

        userResponse.setRoles( mapRoles(user.getRoles()) );

        return userResponse;
    }
}
