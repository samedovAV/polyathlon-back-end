package ru.samedov.polyathlonbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.samedov.polyathlonbackend.domain.Participation;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findAllBySportsmanId(Long sportsmanId);
}
