package ru.samedov.polyathlonbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.samedov.polyathlonbackend.domain.User;

import java.util.Optional;

@Repository
@SuppressWarnings("unused")
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
