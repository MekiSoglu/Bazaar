package by.zeus.demo.service;

import by.zeus.demo.Mapper.CategoryMapper;
import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dao.CategoryRepository;
import by.zeus.demo.dto.CategoryDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.CategoryDetails;
import by.zeus.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends BaseService<Category>{

    private  final CategoryDetailsService categoryDetailsService;
    private final CategoryRepository categoryRepository;


    public CategoryService(BaseRepository<Category> repository, CategoryDetailsService categoryDetailsService, CategoryRepository categoryRepository) {
        super(repository);
        this.categoryDetailsService = categoryDetailsService;
        this.categoryRepository = categoryRepository;
    }

    public Category create(CategoryDto categoryDto){
        Category category=CategoryMapper.toCategory(categoryDto,null,null);
        List<CategoryDetails>  categoryDetails=categoryDetailsService.findAll(categoryDto.getCategoryDetailsId());

        if(categoryDto.getParent_id()!=null){
            Category pCategory=findOne(categoryDto.getParent_id()).get();
            category=CategoryMapper.toCategory(categoryDto,pCategory,categoryDetails);
        }
        return create(category);
    }

    public Category Update(CategoryDto dto) {
        Category pCategory=findOne(dto.getParent_id()).get();
        List<CategoryDetails>  categoryDetails=categoryDetailsService.findAll(dto.getCategoryDetailsId());
        Category model=CategoryMapper.toCategory(dto,pCategory,categoryDetails);
        return super.Update(model);
    }

    public Category findByCategoryProductId(Product product){
        List<Product> products=new ArrayList<>();
        products.add(product);
        Category category=categoryRepository.findCategoryByProductSet(products);
        return category;
    }
    public List<Category> findAll(List<Long> Ids){
        return categoryRepository.findCategoriesBy(Ids);
    }




}
