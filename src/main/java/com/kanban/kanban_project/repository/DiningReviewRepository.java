package com.kanban.kanban_project.repository;

import com.kanban.kanban_project.model.DiningReview;
import com.kanban.kanban_project.model.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {
    List<DiningReview> findByStatus(ReviewStatus pending); // Fetch reviews by status (pending, approved, rejected)

    List<DiningReview> findByRestaurantIdAndStatus(Long restaurantId, ReviewStatus status); // Approved reviews for a restaurant
}
