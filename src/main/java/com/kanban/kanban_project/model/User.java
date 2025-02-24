package com.kanban.kanban_project.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique database ID

    @Column(unique = true, nullable = false)
    private String displayName;  // Unique display name

    private String city;
    private String state;
    private String zipcode;

    private boolean interestedInPeanutAllergy;
    private boolean interestedInEggAllergy;
    private boolean interestedInDairyAllergy;
}
