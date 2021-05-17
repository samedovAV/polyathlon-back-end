package ru.samedov.polyathlonbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.samedov.polyathlonbackend.domain.Participation;
import ru.samedov.polyathlonbackend.repository.ParticipationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipationService {

    private final ParticipationRepository participationRepository;

    public List<Participation> getAllParticipation() {
        return participationRepository.findAll();
    }
}
