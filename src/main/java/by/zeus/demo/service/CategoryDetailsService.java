package by.zeus.demo.service;

import by.zeus.demo.Mapper.CategoryDetailsMapper;
import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dao.CategoryDetailsRepository;
import by.zeus.demo.dto.CategoryDetailsDto;
import by.zeus.demo.entity.CategoryDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDetailsService extends BaseService<CategoryDetails>{
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
