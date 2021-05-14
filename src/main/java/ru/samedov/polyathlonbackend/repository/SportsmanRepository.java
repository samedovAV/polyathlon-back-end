package ru.samedov.polyathlonbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.samedov.polyathlonbackend.domain.Sportsman;

public interface SportsmanRepository extends JpaRepository<Sportsman, Long> {
}
