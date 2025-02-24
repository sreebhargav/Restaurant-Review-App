package com.kanban.kanban_project.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dining_reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;

    @Enumerated(EnumType.STRING)
    private ReviewStatus status = ReviewStatus.PENDING; // Default status
}
