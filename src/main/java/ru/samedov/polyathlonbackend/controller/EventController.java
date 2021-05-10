package ru.samedov.polyathlonbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.samedov.polyathlonbackend.domain.Event;
import ru.samedov.polyathlonbackend.service.EventService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping(value = "/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping(value = "/add-event")
    public void addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
    }
}
