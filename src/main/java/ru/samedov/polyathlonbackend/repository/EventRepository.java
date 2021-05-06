package ru.samedov.polyathlonbackend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.samedov.polyathlonbackend.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
