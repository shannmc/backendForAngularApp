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

            Restaurant restaurant3 = new Restaurant("Taste of Thai");
            restaurant3.setLocation(Location.WEST_ASHLEY);

            User user = new User("shannon", "password");
            userRepository.save(user);

            Category category1 = new Category();
            category1.setCategoryName("Thai");
            Set<Category> categories1 = new HashSet<>();
            categories1.add(category1);
            restaurant1.setAssociatedCategories(categories1);
            categoryRepository.save(category1);
            restaurantRepository.save(restaurant1);


            Category category2 = new Category();
            Category category3 = new Category();
            category2.setCategoryName("Cafe");
            category3.setCategoryName("Chinese");
            Set<Category> categories2 = new HashSet<>();
            categories2.add(category2);
            categories2.add(category3);
            restaurant2.setAssociatedCategories(categories2);
            categoryRepository.save(category2);
            categoryRepository.save(category3);
            restaurantRepository.save(restaurant2);


            restaurant3.setAssociatedCategories(categories1);
            restaurantRepository.save(restaurant3);

        }
    }
}
