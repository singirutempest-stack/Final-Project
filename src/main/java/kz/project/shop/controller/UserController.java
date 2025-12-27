package kz.project.shop.controller;

import kz.project.shop.dto.request.UserUpdateRequest;
import kz.project.shop.dto.response.UserResponse;
import kz.project.shop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public UserResponse update(
            @PathVariable Long id,
            @RequestBody UserUpdateRequest request
    ) {
        return userService.updateProfile(id, request);
    }

    @PatchMapping("/{id}/block")
    public ResponseEntity<Void> block(@PathVariable Long id) {
        userService.blockUser(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
