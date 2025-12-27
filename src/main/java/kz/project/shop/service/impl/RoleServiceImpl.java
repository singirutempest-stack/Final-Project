
package kz.project.shop.service.impl;

import kz.project.shop.dto.request.RoleRequest;
import kz.project.shop.dto.response.RoleResponse;
import kz.project.shop.entity.Role;
import kz.project.shop.mapper.RoleMapper;
import kz.project.shop.repository.RoleRepository;
import kz.project.shop.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository,
                           RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleResponse create(RoleRequest request) {
        Role role = roleMapper.toEntity(request);
        return roleMapper.toResponse(roleRepository.save(role));
    }

    @Override
    public void delete(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new IllegalArgumentException("Role not found");
        }
        roleRepository.deleteById(id);
    }

    @Override
    public List<RoleResponse> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toResponse)
                .collect(Collectors.toList());
    }
}
