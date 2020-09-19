package com.controller;

import com.data.RestaurantRepository;
import com.model.Restaurant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping()
    public List<Restaurant> getAllRestaurants() throws InterruptedException {
//        Thread.sleep(3000);
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable("id") Long id) {
        return restaurantRepository.findById(id).get();
    }

    @PostMapping()
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @PutMapping()
    public void updateRestaurant(@RequestBody Restaurant updatedRestaurant) {
        Restaurant originalRestaurant = restaurantRepository.findById(updatedRestaurant.getId()).get();
        originalRestaurant.setName(updatedRestaurant.getName());
        originalRestaurant.setCategory(updatedRestaurant.getCategory());
        originalRestaurant.setHaveTried(updatedRestaurant.getHaveTried());
        originalRestaurant.setLocation(updatedRestaurant.getLocation());
        originalRestaurant.setRating(updatedRestaurant.getRating());
    }

}

