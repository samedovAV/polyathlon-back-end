package ru.samedov.polyathlonbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.samedov.polyathlonbackend.domain.Event;
import ru.samedov.polyathlonbackend.domain.ParticipationApplication;
import ru.samedov.polyathlonbackend.repository.EventRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserService userService;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(Event event) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (event.getDate() == null) {
            event.setDate(LocalDate.now());
        }
        event.setCreator(userService.getUser(authentication.getName()));
        eventRepository.save(event);
        return event;
    }

    public Event getOneEvent(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void acceptApplication(ParticipationApplication participationApplication) {
        Event event = eventRepository.findById(participationApplication.getEvent().getId())
                .orElse(null);

        if(event != null) {
            participationApplication.getSportsmen().forEach(event::addSportsman);
        }
    }

    public ResponseEntity<Event> updateEvent(Event eventFromDB, Event event) {

        BeanUtils.copyProperties(event, eventFromDB, "id");

        return new ResponseEntity<>(eventRepository.save(eventFromDB), HttpStatus.OK);
    }
}
