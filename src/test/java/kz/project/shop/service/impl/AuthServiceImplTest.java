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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock UserRepository userRepository;
    @Mock RoleRepository roleRepository;
    @Mock UserMapper userMapper;
    @Mock PasswordEncoder passwordEncoder;
    @Mock JwtService jwtService;

    @InjectMocks AuthServiceImpl authService;

    @Test
    void register_success() {
        UserCreateRequest req = new UserCreateRequest();
        req.setEmail("test@mail.com");
        req.setPassword("123");

        User user = new User();
        Role role = new Role();
        role.setName("USER");

        when(userRepository.findByEmail(req.getEmail())).thenReturn(Optional.empty());
        when(userMapper.toEntity(req)).thenReturn(user);
        when(passwordEncoder.encode("123")).thenReturn("hashed");
        when(roleRepository.findByName("USER")).thenReturn(Optional.of(role));
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.toResponse(user)).thenReturn(new UserResponse());

        UserResponse response = authService.register(req);

        assertNotNull(response);
        verify(userRepository).save(user);
    }

    @Test
    void login_invalidPassword() {
        User user = new User();
        user.setPassword("hashed");

        when(userRepository.findByEmail("a@mail.com"))
                .thenReturn(Optional.of(user));
        when(passwordEncoder.matches("bad", "hashed"))
                .thenReturn(false);

        assertThrows(IllegalArgumentException.class,
                () -> authService.login("a@mail.com", "bad"));
    }
}
