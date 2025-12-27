
package kz.project.shop.service.impl;

import kz.project.shop.dto.response.SellerResponse;
import kz.project.shop.entity.Seller;
import kz.project.shop.entity.User;
import kz.project.shop.mapper.SellerMapper;
import kz.project.shop.repository.SellerRepository;
import kz.project.shop.repository.UserRepository;
import kz.project.shop.service.SellerService;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;
    private final SellerMapper sellerMapper;

    public SellerServiceImpl(SellerRepository sellerRepository,
                             UserRepository userRepository,
                             SellerMapper sellerMapper) {
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public SellerResponse create(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Seller seller = new Seller();
        seller.setUser(user);
        seller.setActive(true);

        return sellerMapper.toResponse(sellerRepository.save(seller));
    }

    @Override
    public SellerResponse getByUserId(Long userId) {
        return sellerRepository.findByUserId(userId)
                .map(sellerMapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));
    }

    @Override
    public SellerResponse deactivate(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));

        seller.setActive(false);
        return sellerMapper.toResponse(sellerRepository.save(seller));
    }

    @Override
    public void delete(Long sellerId) {
        if (!sellerRepository.existsById(sellerId)) {
            throw new IllegalArgumentException("Seller not found");
        }
        sellerRepository.deleteById(sellerId);
    }
}
