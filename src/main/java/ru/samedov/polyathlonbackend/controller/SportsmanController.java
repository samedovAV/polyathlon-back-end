package ru.samedov.polyathlonbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.samedov.polyathlonbackend.domain.Sportsman;
import ru.samedov.polyathlonbackend.errors.SportsmanNotFoundException;
import ru.samedov.polyathlonbackend.repository.SportsmanRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SportsmanController {

    private final SportsmanRepository sportsmanRepository;

    @GetMapping("/sportsman/list")
    public List<Sportsman> getAllSportsmen() {
        return sportsmanRepository.findAll();
    }

    @PostMapping("/sportsman/add-sportsman")
    public Sportsman addSportsman(@RequestBody Sportsman sportsman) {
        return sportsmanRepository.save(sportsman);
    }

    @GetMapping("/sportsman/list/{id}")
    public Sportsman getOneSportsman(@PathVariable Long id) {
        return sportsmanRepository.findById(id)
                .orElseThrow(() -> new SportsmanNotFoundException(id));
    }

    @PutMapping("/sportsman/list/{id}")
    public Sportsman updateSportman(@RequestBody Sportsman sportsman, @PathVariable Long id) {
        return sportsmanRepository.findById(id)
            .map(sportsm -> {
                sportsm.setFirstName(sportsman.getFirstName());
                //todo add all
                return sportsmanRepository.save(sportsm);
            })
            .orElseGet(() -> {
                sportsman.setId(id);
                return sportsmanRepository.save(sportsman);
            });
    }

    @DeleteMapping("/sportsman/list/{id}")
    public void deleteSportsman(@PathVariable Long id) {
        sportsmanRepository.deleteById(id);
    }
}
