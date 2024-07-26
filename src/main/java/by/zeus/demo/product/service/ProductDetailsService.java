package by.zeus.demo.product.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.product.repository.ProductDetailsRepository;
import by.zeus.demo.product.domain.ProductDetails;
import by.zeus.demo.base.service.BaseService;
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
