package by.zeus.demo.category.domain;

import by.zeus.demo.base.domain.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoryDetails extends BaseEntity {

    @Column()
    String name;

    @ManyToMany(mappedBy = "categoryDetailsList", fetch = FetchType.LAZY)
    private List<Category> categoryList = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
