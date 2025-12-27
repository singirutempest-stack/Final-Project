package kz.project.shop.service;

import kz.project.shop.dto.request.RoleRequest;
import kz.project.shop.dto.response.RoleResponse;



import java.util.List;

public interface RoleService {

    RoleResponse create(RoleRequest request);

    void delete(Long id);

    List<RoleResponse> getAll();
}