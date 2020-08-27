package model;

import javax.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String category;

    @Column
    private String location;

    @Column
    private Long rating;

    @Column
    private boolean haveTried;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public boolean isHaveTried() {
        return haveTried;
    }

    public void setHaveTried(boolean haveTried) {
        this.haveTried = haveTried;
    }
}
