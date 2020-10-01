package com.service;

import com.data.RestaurantRepository;
import com.data.UserRepository;
import com.enums.Location;
import com.model.Category;
import com.model.Restaurant;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInitialization {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        if (restaurants.size() == 0) {
            Restaurant restaurant1 = new Restaurant("Olive Garden");
            restaurant1.setLocation(Location.NORTH_CHARLESTON);
            restaurant1.setId(12L);
//            restaurant1.setCategory(Category.ITALIAN);
            restaurantRepository.save(restaurant1);

            Restaurant restaurant2 = new Restaurant("Tasty Thai");
//            restaurant2.setCategory(Category.THAI);
            restaurant2.setLocation(Location.DOWNTOWN);
            restaurant2.setId(13L);
            restaurantRepository.save(restaurant2);

            User user = new User("shannon", "password");
            userRepository.save(user);

            Category category = new Category();
            category.setCategoryName("Thai");
        }
    }
}
