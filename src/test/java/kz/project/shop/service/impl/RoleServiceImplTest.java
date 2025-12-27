package kz.project.shop.service.impl;

import kz.project.shop.dto.request.RoleRequest;
import kz.project.shop.dto.response.RoleResponse;
import kz.project.shop.entity.Role;
import kz.project.shop.mapper.RoleMapper;
import kz.project.shop.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock RoleRepository roleRepository;
    @Mock RoleMapper roleMapper;

    @InjectMocks
    RoleServiceImpl roleService;

    @Test
    void create_shouldSaveRole() {
        when(roleMapper.toEntity(any())).thenReturn(new Role());
        when(roleRepository.save(any())).thenReturn(new Role());
        when(roleMapper.toResponse(any())).thenReturn(new RoleResponse());

        RoleResponse response = roleService.create(new RoleRequest());

        assertNotNull(response);
    }
}
