package by.zeus.demo.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", updatable = false, insertable = false)
    Category parent;

    @Column
    String categoryName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    Set<Product> productSet;


    public Category getParent() {
        return parent;
    }
    //test automatic pipelaline jenkins
    //test automatic pipelaline jenkins
    //test automatic pipelaline jenkins3
    //test ui




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


}
