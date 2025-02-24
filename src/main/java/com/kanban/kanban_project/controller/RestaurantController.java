package com.kanban.kanban_project.controller;

import com.kanban.kanban_project.model.Restaurant;
import com.kanban.kanban_project.repository.RestaurantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
        if (restaurantRepository.existsByNameAndZipCode(restaurant.getName(), restaurant.getZipCode())) {
            return ResponseEntity.badRequest().build(); // Prevent duplicate restaurants
        }
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return ResponseEntity.ok(savedRestaurant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        return restaurantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Restaurant> searchRestaurants(@RequestParam String zipcode, @RequestParam(required = false) String allergy) {
        if (allergy == null) {
            return restaurantRepository.findByZipCodeAndPeanutScoreIsNotNullOrderByPeanutScoreDesc(zipcode);
        }
        return switch (allergy.toLowerCase()) {
            case "peanut" -> restaurantRepository.findByZipCodeAndPeanutScoreIsNotNullOrderByPeanutScoreDesc(zipcode);
            case "egg" -> restaurantRepository.findByZipCodeAndEggScoreIsNotNullOrderByEggScoreDesc(zipcode);
            case "dairy" -> restaurantRepository.findByZipCodeAndDairyScoreIsNotNullOrderByDairyScoreDesc(zipcode);
            default -> List.of(); // Return empty list if allergy is invalid
        };
    }
}
