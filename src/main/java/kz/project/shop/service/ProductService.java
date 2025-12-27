package kz.project.shop.service;
import java.util.List;
import kz.project.shop.dto.request.ProductRequest;
import kz.project.shop.dto.response.ProductResponse;
public interface ProductService {

    ProductResponse create(ProductRequest request);

    ProductResponse update(Long id, ProductRequest request);

    void delete(Long id);

    List<ProductResponse> getAll();
}
