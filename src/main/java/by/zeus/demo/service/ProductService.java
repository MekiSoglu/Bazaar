package by.zeus.demo.service;

import by.zeus.demo.Mapper.ProductMapper;
import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dao.ProductRepository;
import by.zeus.demo.dto.ProductDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.CategoryDetails;
import by.zeus.demo.entity.Product;
import by.zeus.demo.entity.ProductDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService extends BaseService<Product>{

    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    private final ProductDetailsService productDetailsService;


    public ProductService(BaseRepository<Product> repository, CategoryService categoryService, ProductRepository productRepository, ProductDetailsService productDetailsService) {
        super(repository);
        this.categoryService = categoryService;
        this.productRepository = productRepository;
        this.productDetailsService = productDetailsService;
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

    public Page<ProductDto> findByName(String name) {
        List<Product> products=productRepository.findByNameContaining(name);
        List<ProductDto> productDtos=new ArrayList<>();
        for (Product product:products){
            productDtos.add(ProductMapper.toProductDto(product));
        }

        return  new PageImpl<>(productDtos);
    }

    public Map<String,String> showDetails(Long Id){
        Product product=findOne(Id).get();
        Category category= categoryService.findByCategoryProductId(product);
        List<CategoryDetails> categoryDetails=category.getCategoryDetailsList();
        List<ProductDetails> productDetails=productDetailsService.getProductDetails(product.getId());
        Map<String,String> detailsMap = new HashMap<String,String>();
        int i=0;
        if(categoryDetails!=null&&productDetails!=null){
            for(ProductDetails d: productDetails){
                detailsMap.put(categoryDetails.get(i++).getName(),d.getValue());
            }
        }
        return detailsMap;
    }



}
