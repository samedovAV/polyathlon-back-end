package ru.samedov.polyathlonbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.samedov.polyathlonbackend.domain.ParticipationApplication;
import ru.samedov.polyathlonbackend.service.ParticipationApplicationService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/part-application")
@RequiredArgsConstructor
public class ParticipationApplicationController {

    private final ParticipationApplicationService participationApplicationService;

    @GetMapping(value = "/list")
    public List<ParticipationApplication> getAll() {
        return participationApplicationService.getAll();
    }

    @PostMapping("/send-application")
    public ParticipationApplication sendApplication(@RequestBody ParticipationApplication participationApplication) {
        return participationApplicationService.sendApplication(participationApplication);
    }

}
