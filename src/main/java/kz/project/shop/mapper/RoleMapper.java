package kz.project.shop.mapper;

import kz.project.shop.dto.request.RoleRequest;
import kz.project.shop.dto.response.RoleResponse;
import kz.project.shop.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleRequest request);

    RoleResponse toResponse(Role role);
}
