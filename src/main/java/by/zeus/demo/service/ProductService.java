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
import org.springframework.data.domain.PageRequest;
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

    public Page<ProductDto> pageable(List<ProductDto> products, int page, int size) {
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, products.size());
        List<ProductDto> pageContent = products.subList(startIndex, endIndex);
        long totalElements = products.size();
        return new PageImpl<>(pageContent, PageRequest.of(page - 1, size), totalElements);
    }

    public List<ProductDto> listDto(List<Product> products){
        List<ProductDto> result = new ArrayList<>();
        for(Product product:products){
            result.add(ProductMapper.toProductDto(product));
        }
        return result;
    }

    public Page<ProductDto> getAll(int page,int size){
        List<Product> products= findAll();
        return pageable(listDto(products),page,size);
    }
    //a

    public Product update(ProductDto product){
        Category category=categoryService.findOne(product.getCategory_id()).get();
        Product model=ProductMapper.toProduct(product,category);
        return Update(model);
    }

    public Page<ProductDto> findByCategoryId(Long id,int page,int size) {
        List<Product> products=productRepository.findByCategoryId(id);
        return  pageable(listDto(products),page,size);
    }

    public Page<ProductDto> findByName(String name,int page,int size) {
        List<Product> products=productRepository.findByNameContaining(name);
        return  pageable(listDto(products),page,size);
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
