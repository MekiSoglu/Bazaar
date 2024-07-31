package by.zeus.demo.category.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.category.domain.Category;
import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.category.repository.CategoryRepository;
import by.zeus.demo.category.web.dto.CategoryDetailsDto;
import by.zeus.demo.category.web.mapper.CategoryDetailsMapper;
import by.zeus.demo.category.web.mapper.CategoryMapper;
import by.zeus.demo.product.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends BaseService<Category> {

    private  final CategoryDetailsService categoryDetailsService;
    private final  CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    private final CategoryDetailsMapper categoryDetailsMapper;


    public CategoryService(BaseRepository<Category> repository, CategoryDetailsService categoryDetailsService,
                           CategoryRepository categoryRepository, final CategoryMapper categoryMapper,
                           final CategoryDetailsMapper categoryDetailsMapper) {
        super(repository);
        this.categoryDetailsService = categoryDetailsService;
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.categoryDetailsMapper = categoryDetailsMapper;
    }

    public Category findByCategoryProductId(Product product){
        List<Product> products =new ArrayList<>();
        products.add(product);
        Category category=categoryRepository.findCategoryByProductSet(products);
        return category;
    }

    public List<CategoryDetailsDto> getCategoryDetails(Long categoryId) {
        List<CategoryDetails> categoryDetailsList = categoryRepository.findCategoryDetailsByCategoryId(categoryId);
        List<CategoryDetailsDto> categoryDetailsDtos=new ArrayList<>();
        for(CategoryDetails categoryDetails:categoryDetailsList){
            categoryDetailsDtos.add(categoryDetailsMapper.toDto(categoryDetails));
        }
       return categoryDetailsDtos;
    }
    public List<Category> findAll(List<Long> Ids){
        return categoryRepository.findCategoriesBy(Ids);
    }




}
