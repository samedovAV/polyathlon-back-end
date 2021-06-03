package ru.samedov.polyathlonbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.samedov.polyathlonbackend.domain.Event;
import ru.samedov.polyathlonbackend.domain.ParticipationApplication;
import ru.samedov.polyathlonbackend.service.EventService;
import ru.samedov.polyathlonbackend.service.ParticipationApplicationService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final ParticipationApplicationService participationApplicationService;

    @GetMapping(value = "/events/list")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping(value = "/events/list/{id}")
    public Event getOneEvent(@PathVariable Long id) {
        return eventService.getOneEvent(id);
    }

    @PostMapping(value = "/add-event")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @GetMapping(value = "/get-applications")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<ParticipationApplication> getApplications(@RequestBody Event event) {
        // todo по event_id
        return participationApplicationService.getAllForEvent(event);
    }

    @PostMapping(value = "/accept-application")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void acceptApplication(@RequestBody ParticipationApplication participationApplication) {
        eventService.acceptApplication(participationApplication);
    }

    @PutMapping("/events/update-event/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") Event eventFromDB,
                                             @RequestBody Event event) {
        return eventService.updateEvent(eventFromDB, event);
    }

}
