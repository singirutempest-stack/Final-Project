package kz.project.shop.service.impl;

import kz.project.shop.entity.Seller;
import kz.project.shop.entity.User;
import kz.project.shop.mapper.SellerMapper;
import kz.project.shop.repository.SellerRepository;
import kz.project.shop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SellerServiceImplTest {

    @Mock SellerRepository sellerRepository;
    @Mock UserRepository userRepository;
    @Mock SellerMapper sellerMapper;

    @InjectMocks SellerServiceImpl sellerService;

    @Test
    void create_success() {
        User user = new User();
        Seller seller = new Seller();

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));
        when(sellerRepository.save(any()))
                .thenReturn(seller);
        when(sellerMapper.toResponse(seller))
                .thenReturn(null);

        assertNotNull(sellerService.create(1L));
    }
}
