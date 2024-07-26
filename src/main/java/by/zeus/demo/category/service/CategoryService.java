package by.zeus.demo.category.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.category.domain.Category;
import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.category.repository.CategoryRepository;
import by.zeus.demo.category.web.dto.CategoryDetailsDto;
import by.zeus.demo.category.web.dto.CategoryDto;
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


    public CategoryService(BaseRepository<Category> repository, CategoryDetailsService categoryDetailsService,
                           CategoryRepository categoryRepository) {
        super(repository);
        this.categoryDetailsService = categoryDetailsService;
        this.categoryRepository = categoryRepository;
    }

    public Category toCategory(CategoryDto categoryDto, Category pcategory, List<CategoryDetails> categoryDetails) {
        return CategoryMapper.toCategory(categoryDto, pcategory, categoryDetails);
    }

    public Category create(CategoryDto categoryDto){
        Category category=CategoryMapper.toCategory(categoryDto,null,null);
        List<CategoryDetails>  categoryDetails=categoryDetailsService.findAll(categoryDto.getCategoryDetailsId());

        if(categoryDto.getParent_id()!=null){
            Category pCategory=findOne(categoryDto.getParent_id()).get();
            category=toCategory(categoryDto,pCategory,categoryDetails);
        }
        return create(category);
    }

    public Category Update(CategoryDto dto) {
        Category pCategory=findOne(dto.getParent_id()).get();
        List<CategoryDetails>  categoryDetails=categoryDetailsService.findAll(dto.getCategoryDetailsId());
        Category model=toCategory(dto,pCategory,categoryDetails);
        return super.Update(model);
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
            categoryDetailsDtos.add(CategoryDetailsMapper.toDto(categoryDetails));
        }
       return categoryDetailsDtos;
    }
    public List<Category> findAll(List<Long> Ids){
        return categoryRepository.findCategoriesBy(Ids);
    }




}
