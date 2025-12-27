//
//package kz.project.shop.controller;
//
//import kz.project.shop.dto.request.ChangePasswordRequest;
//import kz.project.shop.dto.request.LoginRequest;
//import kz.project.shop.dto.request.UserCreateRequest;
//import kz.project.shop.dto.response.UserResponse;
//import kz.project.shop.service.AuthService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import kz.project.shop.dto.response.LoginResponse;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/register")
//    public UserResponse register(@RequestBody UserCreateRequest request) {
//        return authService.register(request);
//    }
//
//    @PostMapping("/login")
//    public LoginResponse login(@RequestBody LoginRequest request) {
//        return authService.login(
//                request.getEmail(),
//                request.getPassword()
//        );
//    }
//
//    @PostMapping("/change-password")
//    public ResponseEntity<Void> changePassword(
//            @RequestBody ChangePasswordRequest request
//    ) {
//        authService.changePassword(
//                request.getUserId(),
//                request.getOldPassword(),
//                request.getNewPassword()
//        );
//        return ResponseEntity.ok().build();
//    }
//}



package kz.project.shop.controller;

import kz.project.shop.dto.request.ChangePasswordRequest;
import kz.project.shop.dto.request.LoginRequest;
import kz.project.shop.dto.request.UserCreateRequest;
import kz.project.shop.dto.response.LoginResponse;
import kz.project.shop.dto.response.UserResponse;
import kz.project.shop.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserCreateRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(
                request.getEmail(),
                request.getPassword()
        );
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(
            @RequestBody ChangePasswordRequest request,
            Authentication authentication
    ) {
        authService.changePassword(
                authentication.getName(),
                request.getOldPassword(),
                request.getNewPassword()
        );
        return ResponseEntity.ok().build();
    }
}