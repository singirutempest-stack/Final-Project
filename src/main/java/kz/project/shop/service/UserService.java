package kz.project.shop.service;

import kz.project.shop.dto.request.UserUpdateRequest;
import kz.project.shop.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse getById(Long id);

    List<UserResponse> getAll();

    UserResponse updateProfile(Long userId, UserUpdateRequest request);

    void blockUser(Long userId);

    void deleteUser(Long userId);
}
