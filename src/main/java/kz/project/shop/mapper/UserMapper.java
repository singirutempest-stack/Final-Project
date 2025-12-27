package kz.project.shop.mapper;

import kz.project.shop.dto.request.UserCreateRequest;
import kz.project.shop.dto.response.UserResponse;
import kz.project.shop.entity.Role;
import kz.project.shop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateRequest request);

    @Mapping(target = "roles", expression = "java(mapRoles(user.getRoles()))")
    UserResponse toResponse(User user);

    default Set<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}
