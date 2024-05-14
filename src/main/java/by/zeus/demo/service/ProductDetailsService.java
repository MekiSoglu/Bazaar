package by.zeus.demo.service;

import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dao.ProductDetailsRepository;
import by.zeus.demo.entity.ProductDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsService extends BaseService<ProductDetails> {
    private final ProductDetailsRepository productDetailsRepository;

    public ProductDetailsService(BaseRepository<ProductDetails> repository, ProductDetailsRepository productDetailsRepository) {
        super(repository);
        this.productDetailsRepository = productDetailsRepository;
    }

    public List<ProductDetails> getProductDetails(Long productId){
        return productDetailsRepository.findByProductId(productId);
    }


}
