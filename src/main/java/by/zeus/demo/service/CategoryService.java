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
        Category pCategory=find(categoryDto.getCategoryParentId());
        if(pCategory==null){

        }
        Category category=CategoryMapper.toCategory(categoryDto,pCategory);
        return create(category);
    }



    public Category find(Long Id){
        Optional<Category> category=getOne(Id);
        if(!category.isEmpty()){
            return category.get();
        }else{
            return null;
        }
    }

    @Override
    public Category Update(Category model) {
        return super.Update(model);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
