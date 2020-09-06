package com.controller;

import com.data.RestaurantRepository;
import com.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping()
    public List<Restaurant> getAllRooms() {
        return restaurantRepository.findAll();
    }

    @PostMapping("/add")
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

}

