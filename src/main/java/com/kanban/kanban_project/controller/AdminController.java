package com.kanban.kanban_project.controller;

import com.kanban.kanban_project.model.DiningReview;
import com.kanban.kanban_project.model.ReviewStatus;
import com.kanban.kanban_project.repository.DiningReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final DiningReviewRepository reviewRepository;

    public AdminController(DiningReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PutMapping("/reviews/{id}/approve")
    public ResponseEntity<DiningReview> approveReview(@PathVariable Long id) {
        Optional<DiningReview> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isEmpty()) return ResponseEntity.notFound().build();

        DiningReview review = optionalReview.get();
        review.setStatus(ReviewStatus.APPROVED);
        reviewRepository.save(review);

        return ResponseEntity.ok(review);
    }

    @PutMapping("/reviews/{id}/reject")
    public ResponseEntity<DiningReview> rejectReview(@PathVariable Long id) {
        Optional<DiningReview> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isEmpty()) return ResponseEntity.notFound().build();

        DiningReview review = optionalReview.get();
        review.setStatus(ReviewStatus.REJECTED);
        reviewRepository.save(review);

        return ResponseEntity.ok(review);
    }
}
