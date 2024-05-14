package by.zeus.demo.dao;

import by.zeus.demo.entity.ProductDetails;

import java.util.List;

public interface ProductDetailsRepository extends BaseRepository<ProductDetails> {
    List<ProductDetails> findByProductId(Long productId);
}
