package com.kanban.kanban_project.repository;

import com.kanban.kanban_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByDisplayName(String displayName); // Fetch user by unique display name

    boolean existsByDisplayName(String displayName); 
}
