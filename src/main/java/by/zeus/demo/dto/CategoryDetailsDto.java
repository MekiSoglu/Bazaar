package by.zeus.demo.dto;

import java.util.List;

public class CategoryDetailsDto {
    Long id;

    String name;
    List<Long> categoryList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Long> categoryList) {
        this.categoryList = categoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
