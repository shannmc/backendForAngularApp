//package com.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//public class RestaurantToCategory {
//
//    @Column
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @Column
//    private Long restaurantId;
//
//    @Column
//    private Long categoryId;
//
//    @ManyToMany
//    Set<Category> associatedCategories;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getRestaurantId() {
//        return restaurantId;
//    }
//
//    public void setRestaurantId(Long restaurantId) {
//        this.restaurantId = restaurantId;
//    }
//
//    public Long getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Long categoryId) {
//        this.categoryId = categoryId;
//    }
//}
