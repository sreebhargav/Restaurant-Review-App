package com.kanban.kanban_project.repository;

import com.kanban.kanban_project.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    // ✅ Check if a restaurant exists by name and zipcode
    boolean existsByNameAndZipCode(String name, String zipCode);

    // ✅ Find restaurant by Id
    Optional<Restaurant> findById(Long id);

    // ✅ Find restaurants by zip code and allergy score (descending order)
    List<Restaurant> findByZipCodeAndPeanutScoreIsNotNullOrderByPeanutScoreDesc(String zipCode);
    List<Restaurant> findByZipCodeAndEggScoreIsNotNullOrderByEggScoreDesc(String zipCode);
    List<Restaurant> findByZipCodeAndDairyScoreIsNotNullOrderByDairyScoreDesc(String zipCode);
}
