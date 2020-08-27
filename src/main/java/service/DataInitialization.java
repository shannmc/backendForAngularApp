package service;

import data.RestaurantRepository;
import data.UserRepository;
import model.Restaurant;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInitialization {

    @Autowired
    RestaurantRepository restaurantRespository;

    @Autowired
    UserRepository userRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        List<Restaurant> restaurants = restaurantRespository.findAll();
        if (restaurants.size() == 0) {
            Restaurant blueRestaurant = new Restaurant("Olive Garden");
            restaurantRespository.save(blueRestaurant);

            Restaurant redRestaurant = new Restaurant("Tasty Thai");
            restaurantRespository.save(redRestaurant);

            User user = new User("shannon", "password");
            userRepository.save(user);
        }
    }
}
