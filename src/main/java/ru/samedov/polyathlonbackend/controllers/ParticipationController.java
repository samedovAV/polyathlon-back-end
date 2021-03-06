package ru.samedov.polyathlonbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.samedov.polyathlonbackend.domain.Participation;
import ru.samedov.polyathlonbackend.service.ParticipationService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/participation")
@RequiredArgsConstructor
public class ParticipationController {

    private final ParticipationService participationService;

    @GetMapping(value = "/list/{id}")
    public List<Participation> getAllParticipation(@PathVariable Long id) {
        return participationService.getAllParticipation(id);
    }
}
