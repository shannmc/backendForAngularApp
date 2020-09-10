package com.controller;

import com.data.RestaurantRepository;
import com.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping()
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable("id") Long id) {
        return restaurantRepository.findById(id).get();
    }

    @PostMapping()
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @PutMapping()
    public void updateRestaurant(@RequestBody Restaurant updatedRestaurant) {
        Restaurant originalRestaurant = restaurantRepository.findById(updatedRestaurant.getId()).get();
        originalRestaurant.setName(updatedRestaurant.getName());
        originalRestaurant.setCategory(updatedRestaurant.getCategory());
    }

}

