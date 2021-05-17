package ru.samedov.polyathlonbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.samedov.polyathlonbackend.domain.Participation;
import ru.samedov.polyathlonbackend.service.ParticipationService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/participation")
@RequiredArgsConstructor
public class ParticipationController {

    private final ParticipationService participationService;

    @GetMapping(value = "/list")
    public List<Participation> getAllParticipation() {
        return participationService.getAllParticipation();
    }
}
