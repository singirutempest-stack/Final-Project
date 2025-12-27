//package kz.project.shop.service;
//
//import kz.project.shop.dto.request.UserCreateRequest;
//import kz.project.shop.dto.response.UserResponse;


//package kz.project.shop.service;
//
//import kz.project.shop.dto.request.UserCreateRequest;
//import kz.project.shop.dto.response.UserResponse;
//import kz.project.shop.dto.response.LoginResponse;
//public interface AuthService {
//
//    UserResponse register(UserCreateRequest request);
//
//    LoginResponse login(String email, String password);
//
//    void changePassword(Long userId, String oldPassword, String newPassword);
//}


package kz.project.shop.service;

import kz.project.shop.dto.request.UserCreateRequest;
import kz.project.shop.dto.response.LoginResponse;
import kz.project.shop.dto.response.UserResponse;

public interface AuthService {

    UserResponse register(UserCreateRequest request);

    LoginResponse login(String email, String password);

    void changePassword(String email, String oldPassword, String newPassword);
}