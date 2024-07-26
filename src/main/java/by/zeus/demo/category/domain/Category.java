package by.zeus.demo.category.domain;

import by.zeus.demo.base.domain.BaseEntity;
import by.zeus.demo.product.domain.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    Category parent;

    @Column
    String categoryName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    Set<Product> productSet;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_category_details",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "category_details_id"))
    private List<CategoryDetails> categoryDetailsList = new ArrayList<>();

    public List<CategoryDetails> getCategoryDetailsList() {
        return categoryDetailsList;
    }

    public void setCategoryDetailsList(List<CategoryDetails> categoryDetailsList) {
        this.categoryDetailsList = categoryDetailsList;
    }

    public Category getParent() {
        return parent;
    }

//tesst
    public void setParent(Category parent) {
        this.parent = parent;
    }

    //sdfsdfsd

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
// brench deneme

}
