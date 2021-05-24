package ru.samedov.polyathlonbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.samedov.polyathlonbackend.domain.Event;
import ru.samedov.polyathlonbackend.domain.ParticipationApplication;
import ru.samedov.polyathlonbackend.repository.ParticipationApplicationRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ParticipationApplicationService {

    private final ParticipationApplicationRepository participationApplicationRepository;

    public List<ParticipationApplication> getAll() {
        return participationApplicationRepository.findAll();
    }

    public List<ParticipationApplication> getAllForEvent(Event event) {
        return participationApplicationRepository.getAllByEventId(event.getId());
    }

    public ParticipationApplication sendApplication(ParticipationApplication participationApplication) {

        participationApplication.setCreator(participationApplication.getCreator());
        participationApplicationRepository.save(participationApplication);
        return participationApplication;
    }
}
