package com.service;

import com.data.CategoryRepository;
import com.data.RestaurantRepository;
import com.data.UserRepository;
import com.enums.Location;
import com.model.Category;
import com.model.Restaurant;
import com.model.User;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataInitialization {

    final RestaurantRepository restaurantRepository;

    final UserRepository userRepository;

    final CategoryRepository categoryRepository;

    final EntityManager entityManager;

    public DataInitialization(RestaurantRepository restaurantRepository, UserRepository userRepository, CategoryRepository categoryRepository, EntityManager entityManager) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.entityManager = entityManager;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        if (restaurants.size() == 0) {
            Restaurant restaurant1 = new Restaurant("Olive Garden");
            restaurant1.setLocation(Location.NORTH_CHARLESTON);

            Restaurant restaurant2 = new Restaurant("Tasty Thai");
            restaurant2.setLocation(Location.DOWNTOWN);
            restaurantRepository.save(restaurant2);

            User user = new User("shannon", "password");
            userRepository.save(user);

            Category category = new Category();
            category.setCategoryName("Thai");

            restaurant1.addCategory(category);
            categoryRepository.save(category);

            Set<Category> categories = new HashSet<Category>();
            categories.add(category);
            restaurant1.setAssociatedCategories(categories);

            restaurantRepository.save(restaurant1);





//            Set<Category> restaurantCatSet = new HashSet<Category>(Arrays.asList(category));
//            restaurantCatSet.add(category);
////            Set<Restaurant> categoryRestSet = new HashSet<Restaurant>(Arrays.asList(restaurant1));
//
////
////
////            restaurant1.setAssociatedCategories(restaurantCatSet);
////            category.setRestaurantsInCategory(categoryRestSet);
//            restaurantRepository.save(restaurant1);
////            categoryRepository.save(category);
        }
    }
}
