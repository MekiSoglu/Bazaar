package by.zeus.demo.category.service;

import by.zeus.demo.base.repository.BaseRepository;
import by.zeus.demo.category.repository.CategoryDetailsRepository;
import by.zeus.demo.category.web.dto.CategoryDetailsDto;
import by.zeus.demo.category.domain.CategoryDetails;
import by.zeus.demo.base.service.BaseService;
import by.zeus.demo.category.web.mapper.CategoryDetailsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDetailsService extends BaseService<CategoryDetails> {
   private final CategoryDetailsRepository categoryRepository;

    public CategoryDetailsService(BaseRepository<CategoryDetails> repository, CategoryDetailsRepository categoryRepository) {
        super(repository);
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDetails> findAll(List<Long> Ids){
        return categoryRepository.findCategoryDetailsBy(Ids);
    }

    public void create(CategoryDetailsDto categoryDetailsDto){
        CategoryDetails categoryDetails= CategoryDetailsMapper.toCategoryDetails(categoryDetailsDto);
        create(categoryDetails);
    }

    public void Update(CategoryDetailsDto categoryDetailsDto){
        CategoryDetails categoryDetails= CategoryDetailsMapper.toCategoryDetails(categoryDetailsDto);
        Update(categoryDetails);
    }

}
