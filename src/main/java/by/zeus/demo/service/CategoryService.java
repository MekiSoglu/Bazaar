package by.zeus.demo.service;

import by.zeus.demo.dao.BaseRepository;
import by.zeus.demo.entity.Category;

public class CategoryService extends BaseService<Category>{
    public CategoryService(BaseRepository<Category> repository) {
        super(repository);
    }

    public Category create(Category category){
        return create(category);
    }

    public Category find(Long Id){
        return find(Id);
    }
}
