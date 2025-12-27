//
//package kz.project.shop.service.impl;
//
//import kz.project.shop.dto.request.UserCreateRequest;
//import kz.project.shop.dto.response.UserResponse;
//import kz.project.shop.entity.Role;
//import kz.project.shop.entity.User;
//import kz.project.shop.mapper.UserMapper;
//import kz.project.shop.repository.RoleRepository;
//import kz.project.shop.repository.UserRepository;
//import kz.project.shop.service.AuthService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import kz.project.shop.dto.response.LoginResponse;
//import kz.project.shop.security.JwtService;
//
//@Service
//public class AuthServiceImpl implements AuthService {
//
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final UserMapper userMapper;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtService jwtService;
//
//    public AuthServiceImpl(UserRepository userRepository,
//                           RoleRepository roleRepository,
//                           UserMapper userMapper,
//                           PasswordEncoder passwordEncoder,
//                           JwtService jwtService) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.userMapper = userMapper;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtService = jwtService;
//    }
//
//
//    @Override
//    public UserResponse register(UserCreateRequest request) {
//        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
//            throw new IllegalArgumentException("Email already exists");
//        }
//
//        User user = userMapper.toEntity(request);
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//
//        Role role = roleRepository.findByName("USER")
//                .orElseThrow(() -> new IllegalStateException("Role USER not found"));
//
//        user.getRoles().add(role);
//
//        return userMapper.toResponse(userRepository.save(user));
//    }
//
//    @Override
//    public LoginResponse login(String email, String password) {
//
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
//
//        if (user.isBlocked()) {
//            throw new IllegalStateException("User is blocked");
//        }
//
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new IllegalArgumentException("Invalid credentials");
//        }
//
//        String token = jwtService.generateToken(user.getEmail());
//
//        return new LoginResponse(
//                token,
//                userMapper.toResponse(user)
//        );
//    }
//
//
//    @Override
//    public void changePassword(Long userId, String oldPassword, String newPassword) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
//
//        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
//            throw new IllegalArgumentException("Old password is incorrect");
//        }
//
//        user.setPassword(passwordEncoder.encode(newPassword));
//        userRepository.save(user);
//    }
//}


package kz.project.shop.service.impl;

import kz.project.shop.dto.request.UserCreateRequest;
import kz.project.shop.dto.response.LoginResponse;
import kz.project.shop.dto.response.UserResponse;
import kz.project.shop.entity.Role;
import kz.project.shop.entity.User;
import kz.project.shop.mapper.UserMapper;
import kz.project.shop.repository.RoleRepository;
import kz.project.shop.repository.UserRepository;
import kz.project.shop.security.JwtService;
import kz.project.shop.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           UserMapper userMapper,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public UserResponse register(UserCreateRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Role role = roleRepository.findByName("USER")
                .orElseThrow(() -> new IllegalStateException("Role USER not found"));

        user.getRoles().add(role);

        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public LoginResponse login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (user.isBlocked()) {
            throw new IllegalStateException("User is blocked");
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(
                token,
                userMapper.toResponse(user)
        );
    }

    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}