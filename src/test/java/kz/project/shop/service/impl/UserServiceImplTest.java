package kz.project.shop.service.impl;

import kz.project.shop.entity.User;
import kz.project.shop.mapper.UserMapper;
import kz.project.shop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock UserRepository userRepository;
    @Mock UserMapper userMapper;

    @InjectMocks UserServiceImpl userService;

    @Test
    void blockUser_success() {
        User user = new User();

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        userService.blockUser(1L);

        verify(userRepository).save(user);
    }
}
