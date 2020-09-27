package com.model;

import com.enums.Category;
import com.enums.Location;

import javax.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Category category;

    @Column
    private Location location;

    @Column
    private Long rating;

    @Column
    private boolean haveTried;

    @Column
    private String notes;

    public Restaurant(String name) {
        this.name = name;
        }

    public Restaurant() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public boolean getHaveTried() {
        return haveTried;
    }

    public void setHaveTried(boolean haveTried) {
        this.haveTried = haveTried;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
