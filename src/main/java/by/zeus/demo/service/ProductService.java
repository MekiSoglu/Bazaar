package by.zeus.demo.service;

import by.zeus.demo.Mapper.ProductMapper;
import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends BaseService<Product>{

    private final CategoryService categoryService;


    public ProductService(BaseRepository<Product> repository, CategoryService categoryService) {
        super(repository);
        this.categoryService = categoryService;
    }


    public Product create(ProductDto productDto){
        Category category= categoryService.findOne(productDto.getCategory_id()).get();
        Product product=ProductMapper.toProduct(productDto,category);
        return create(product);
    }

    public List<ProductDto> getAll(){
        List<Product> products= findAll();
        List<ProductDto> result= new ArrayList<>();
        for(Product product:products){
            result.add( ProductMapper.toProductDto(product));
        }
        return result;
    }

    public Product update(ProductDto product){
        Category category=categoryService.findOne(product.getCategory_id()).get();
        Product model=ProductMapper.toProduct(product,category);
       return Update(model);
    }

}
