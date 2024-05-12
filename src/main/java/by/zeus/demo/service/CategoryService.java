package by.zeus.demo.service;

import by.zeus.demo.Mapper.CategoryMapper;
import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dto.CategoryDto;
import by.zeus.demo.entity.Category;
import by.zeus.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService extends BaseService<Category>{


    public CategoryService(BaseRepository<Category> repository) {
        super(repository);
    }

    public Category create(CategoryDto categoryDto){
        Category category=CategoryMapper.toCategory(categoryDto,null);

        if(categoryDto.getParent_id()!=null){
            Category pCategory=findOne(categoryDto.getParent_id()).get();
             category=CategoryMapper.toCategory(categoryDto,pCategory);


        }
        return create(category);
    }





    public Category Update(CategoryDto dto) {
        Category pCategory=findOne(dto.getParent_id()).get();
        Category model=CategoryMapper.toCategory(dto,pCategory);
        return super.Update(model);
    }




}
