package ru.samedov.polyathlonbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.samedov.polyathlonbackend.domain.Participation;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
}
