package by.zeus.demo.service;

import by.zeus.demo.Mapper.ProductMapper;
import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService extends BaseService<Product>{

    private final CategoryService categoryService;

    public ProductService(BaseRepository<Product> repository, CategoryService categoryService) {
        super(repository);
        this.categoryService = categoryService;
    }


    public Product create(ProductDto productDto){
        Category category= categoryService.find(productDto.getCategoryId());
        Product product=ProductMapper.toProduct(productDto,category);
        return create(product);
    }

    public ProductDto find(Long Id){
        Optional<Product> product=getOne(Id);
        if(!product.isEmpty()){
          return ProductMapper.toProductDto(product.get());
        }else{
            return null;
        }
    }

    public void delete(Long Id){
        delete(Id);
    }

    public Product update(Product product){
       return update(product);
    }

}
