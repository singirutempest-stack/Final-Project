//package kz.project.shop.controller;
//
//import kz.project.shop.dto.request.RoleRequest;
//import kz.project.shop.dto.response.RoleResponse;
//import kz.project.shop.service.RoleService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/roles")
//public class RoleController {
//
//    private final RoleService roleService;
//
//    public RoleController(RoleService roleService) {
//        this.roleService = roleService;
//    }
//
//    @PostMapping
//    public RoleResponse create(@RequestBody RoleRequest request) {
//        return roleService.create(request);
//    }
//
//    @GetMapping
//    public List<RoleResponse> getAll() {
//        return roleService.getAll();
//    }
//}

package kz.project.shop.controller;

import kz.project.shop.dto.request.RoleRequest;
import kz.project.shop.dto.response.RoleResponse;
import kz.project.shop.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleResponse create(@RequestBody RoleRequest request) {
        return roleService.create(request);
    }

    @GetMapping
    public List<RoleResponse> getAll() {
        return roleService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}


