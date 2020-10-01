package com.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private String categoryName;

//    private Long restaurantId;

    @ManyToMany(mappedBy = "associatedCategories")
    Set<Restaurant> restaurantsInCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Restaurant> getRestaurantsInCategory() {
        return restaurantsInCategory;
    }

    public void setRestaurantsInCategory(Set<Restaurant> restaurantsInCategory) {
        this.restaurantsInCategory = restaurantsInCategory;
    }
}
