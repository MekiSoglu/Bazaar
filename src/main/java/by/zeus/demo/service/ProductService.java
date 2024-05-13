package by.zeus.demo.service;

import by.zeus.demo.Mapper.ProductMapper;
import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dao.ProductRepository;
import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends BaseService<Product>{

    private final CategoryService categoryService;
    private final ProductRepository productRepository;


    public ProductService(BaseRepository<Product> repository, CategoryService categoryService, ProductRepository productRepository) {
        super(repository);
        this.categoryService = categoryService;
        this.productRepository = productRepository;
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

    public Page<ProductDto> findByCategoryId(Long id) {
        List<Product> products=productRepository.findByCategoryId(id);
        List<ProductDto> productDtos=new ArrayList<>();
        for (Product product:products){
            productDtos.add(ProductMapper.toProductDto(product));
        }

        return  new PageImpl<>(productDtos);
    }
}
