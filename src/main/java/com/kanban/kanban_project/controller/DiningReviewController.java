package com.kanban.kanban_project.controller;

import com.kanban.kanban_project.model.DiningReview;
import com.kanban.kanban_project.model.ReviewStatus;
import com.kanban.kanban_project.model.User;
import com.kanban.kanban_project.model.Restaurant;
import com.kanban.kanban_project.repository.DiningReviewRepository;
import com.kanban.kanban_project.repository.UserRepository;
import com.kanban.kanban_project.repository.RestaurantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class DiningReviewController {

    private final DiningReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public DiningReviewController(DiningReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping
    public ResponseEntity<?> submitReview(@RequestBody DiningReview review) {
        // Validate user exists
        Optional<User> user = userRepository.findByDisplayName(review.getUser().getDisplayName());
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Validate restaurant exists
        Optional<Restaurant> restaurant = restaurantRepository.findById(review.getRestaurant().getId());
        if (restaurant.isEmpty()) {
            return ResponseEntity.badRequest().body("Restaurant not found");
        }

        // Set validated user and restaurant
        review.setUser(user.get());
        review.setRestaurant(restaurant.get());
        review.setStatus(ReviewStatus.PENDING); // Default to PENDING status

        DiningReview savedReview = reviewRepository.save(review);
        return ResponseEntity.ok(savedReview);
    }

    @GetMapping("/pending")
    public List<DiningReview> getPendingReviews() {
        return reviewRepository.findByStatus(ReviewStatus.PENDING);
    }
}

