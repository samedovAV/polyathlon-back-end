package ru.samedov.polyathlonbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.samedov.polyathlonbackend.domain.ParticipationApplication;

@Repository
public interface ParticipationApplicationRepository extends JpaRepository<ParticipationApplication, Long> {
}
