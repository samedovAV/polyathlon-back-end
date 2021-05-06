package ru.samedov.polyathlonbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.samedov.polyathlonbackend.domain.Event;
import ru.samedov.polyathlonbackend.repository.EventRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void addEvent(Event event) {
        if (event.getDate() == null) {
            event.setDate(LocalDate.now());
        }
        eventRepository.save(event);
    }
}
