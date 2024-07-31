package by.zeus.demo.category.domain;

import by.zeus.demo.base.domain.BaseEntity;
import by.zeus.demo.product.domain.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {

    @Column(name="parent_id")
    private Long parentId;

    @Column
    String categoryName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    Set<Product> productSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_category_details",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "category_details_id"))
    private List<CategoryDetails> categoryDetailsList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id" ,insertable = false,updatable = false)
    Category parent;

    public List<CategoryDetails> getCategoryDetailsList() {
        return categoryDetailsList;
    }

    public void setCategoryDetailsList(List<CategoryDetails> categoryDetailsList) {
        this.categoryDetailsList = categoryDetailsList;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(final Long parentId) {
        this.parentId = parentId;
    }
}
