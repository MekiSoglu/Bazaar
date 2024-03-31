package by.zeus.demo.dto;

import by.zeus.demo.entity.Product;

import java.util.Set;

public class CategoryDto {

    Long Id;

    Long CategoryParentId;

    String categoryName;

    int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getId() {
        return Id;
    }



    public void setId(Long id) {
        Id = id;
    }

    public Long getCategoryParentId() {
        return CategoryParentId;
    }

    public void setCategoryParentId(Long categoryParentId) {
        CategoryParentId = categoryParentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    Set<Product> productSet;
}
