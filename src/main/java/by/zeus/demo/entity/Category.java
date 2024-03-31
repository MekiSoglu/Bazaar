package by.zeus.demo.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", updatable = false, insertable = false)
    Category parent;

    @Column
    String categoryName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    Set<Product> productSet;
}
