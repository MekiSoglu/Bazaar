package by.zeus.demo.category.web.dto;

import by.zeus.demo.base.web.dto.BaseDTO;

import java.util.List;

public class CategoryDetailsDto extends BaseDTO {

    String name;

    List<CategoryDetailsDto> categoryList;


    public List<CategoryDetailsDto> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(final List<CategoryDetailsDto> categoryList) {
        this.categoryList = categoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
