package by.zeus.demo.product.service;
import by.zeus.demo.product.web.mapper.ProductMapper;
import by.zeus.demo.category.service.CategoryService;
import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.product.repository.ProductRepository;
import by.zeus.demo.category.domain.Category;
import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.product.domain.Product;
import by.zeus.demo.product.domain.ProductDetails;
import by.zeus.demo.base.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductService extends BaseService<Product> {

    private final CategoryService   categoryService;
    private final ProductRepository     productRepository;
    private final ProductDetailsService productDetailsService;

    private final ProductMapper productMapper;

    public ProductService(BaseRepository<Product> repository, CategoryService categoryService, ProductRepository productRepository, ProductDetailsService productDetailsService,
                          final ProductMapper productMapper) {
        super(repository);
        this.categoryService = categoryService;
        this.productRepository = productRepository;
        this.productDetailsService = productDetailsService;
        this.productMapper = productMapper;
    }

    public Page<Product> pageable(List<Product> products, Pageable pageable) {
        int page=pageable.getPageNumber();
        int size=pageable.getPageSize();
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, products.size());
        List<Product> pageContent = products.subList(startIndex, endIndex);
        long totalElements = products.size();
        return new PageImpl<>(pageContent, PageRequest.of(page - 1, size), totalElements);
    }


    public Page<Product> findByCategoryId(Long id, Pageable pageable) {
        List<Product> products=productRepository.findByCategoryId(id);
        return  pageable(products,pageable);
    }

    public Page<Product> findByName(String name,Pageable pageable) {
        List<Product> products=productRepository.findByNameContaining(name);
        return  pageable(products,pageable);
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
