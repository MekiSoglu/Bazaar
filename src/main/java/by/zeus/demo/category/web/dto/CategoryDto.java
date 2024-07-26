package by.zeus.demo.category.web.dto;

import java.util.List;
import java.util.Set;


public class CategoryDto {

    Long id;

    Long parent_id;

    String categoryName;

    Set<Long> product_Id;
    List<Long> categoryDetailsId;

    public List<Long> getCategoryDetailsId() {
        return categoryDetailsId;
    }

    public void setCategoryDetailsId(List<Long> categoryDetailsId) {
        this.categoryDetailsId = categoryDetailsId;
    }

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
