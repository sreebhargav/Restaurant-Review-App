package com.kanban.kanban_project.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurants", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "zipCode"}) // Ensures uniqueness of restaurant name per zip code
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String zipCode;

    private Double peanutScore;
    private Double eggScore;
    private Double dairyScore;
    private Double overallScore;
}

