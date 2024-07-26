package by.zeus.demo.product.repository;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.product.domain.ProductDetails;

import java.util.List;

public interface ProductDetailsRepository extends BaseRepository<ProductDetails> {
    List<ProductDetails> findByProductId(Long productId);
}
