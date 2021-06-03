package ru.samedov.polyathlonbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.samedov.polyathlonbackend.domain.Sportsman;

@Repository
public interface SportsmanRepository extends JpaRepository<Sportsman, Long> {
}
