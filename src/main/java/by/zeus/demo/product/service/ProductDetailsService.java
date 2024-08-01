package by.zeus.demo.product.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.product.domain.ProductDetailsEntity;
import by.zeus.demo.product.repository.ProductDetailsRepository;
import by.zeus.demo.base.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsService extends BaseService<ProductDetailsEntity> {
    private final ProductDetailsRepository productDetailsRepository;

    public ProductDetailsService(BaseRepository<ProductDetailsEntity> repository, ProductDetailsRepository productDetailsRepository) {
        super(repository);
        this.productDetailsRepository = productDetailsRepository;
    }

    public List<ProductDetailsEntity> getProductDetails(Long productId){
        return productDetailsRepository.findByProductId(productId);
    }


}
