package com.model;

import com.enums.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Location location;

    @Column
    private Long rating;

    @Column
    private boolean haveTried;

    @Column
    private String notes;

    @ManyToMany
    @JoinTable(
            name = "restaurant_to_category",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> associatedCategories = new HashSet<>();

    public Restaurant(String name) {
        this.name = name;
        }

    public boolean getHaveTried() {
        return haveTried;
    }

    public void setHaveTried(boolean haveTried) {
        this.haveTried = haveTried;
    }

}
