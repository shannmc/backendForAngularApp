package controller;

import data.RestaurantRepository;
import model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @RequestMapping("/restaurants")
    public List<Restaurant> listRooms() {
        return restaurantRepository.findAll();
    }

    @PostMapping("/add")
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

}

