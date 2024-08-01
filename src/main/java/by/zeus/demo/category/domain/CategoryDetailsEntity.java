package by.zeus.demo.category.domain;

import by.zeus.demo.base.domain.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoryDetailsEntity extends BaseEntity {

    @Column()
    String name;

    @ManyToMany(mappedBy = "categoryDetailsList", fetch = FetchType.LAZY)
    private List<CategoryEntity> categoryEntityList = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryEntity> getCategoryList() {
        return categoryEntityList;
    }

    public void setCategoryList(List<CategoryEntity> categoryEntityList) {
        this.categoryEntityList = categoryEntityList;
    }
}
