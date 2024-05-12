package by.zeus.demo.dto;

import by.zeus.demo.entity.Product;

import java.util.Set;


public class CategoryDto {

    Long id;

    Long parent_id;

    String categoryName;

    Set<Long> product_Id;

    public Set<Long> getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(Set<Long> product_Id) {
        this.product_Id = product_Id;
    }

    int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }



  //  Set<Product> productSet;
}
