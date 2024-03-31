package by.zeus.demo.service;

import by.zeus.demo.Mapper.ProductMapper;
import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dao.ProductRepository;
import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product>{

    private final ProductMapper productMapper;

    public ProductService(BaseRepository<Product> repository, final ProductMapper productMapper) {
        super(repository);
        this.productMapper = productMapper;
    }


    public Product create(ProductDto productDto){
        Product product=productMapper.toProduct(productDto);
        return create(product);
    }

    public Product find(Long Id){
        return find(Id);
    }

    public void delete(Long Id){
        delete(Id);
    }

    public Product update(Product product){
       return update(product);
    }

}
