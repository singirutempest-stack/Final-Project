package kz.project.shop.service;

import kz.project.shop.dto.response.SellerResponse;
public interface SellerService {

    SellerResponse create(Long userId);

    SellerResponse getByUserId(Long userId);

    SellerResponse deactivate(Long sellerId);

    void delete(Long sellerId);
}
