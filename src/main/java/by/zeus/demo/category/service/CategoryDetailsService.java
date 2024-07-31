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


    public CategoryDetailsService(BaseRepository<CategoryDetails> repository) {
        super(repository);

    }

    public List<CategoryDetails> findAll(List<Long> Ids){
        return getRepository().findCategoryDetailsBy(Ids);
    }



    @Override
    public CategoryDetailsRepository getRepository(){
        return (CategoryDetailsRepository) super.getRepository();
    }


}
