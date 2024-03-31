package by.zeus.demo.service;

import by.zeus.demo.Mapper.CategoryMapper;
import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.dto.CategoryDto;
import by.zeus.demo.entity.Category;

public class CategoryService extends BaseService<Category>{

    private final CategoryMapper categoryMapper;

    public CategoryService(BaseRepository<Category> repository, CategoryMapper categoryMapper) {
        super(repository);
        this.categoryMapper = categoryMapper;
    }

    public Category create(CategoryDto categoryDto){
        Category category=categoryMapper.toCategory(categoryDto);
        return create(category);
    }

    public Category find(Long Id){
        return find(Id);
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
