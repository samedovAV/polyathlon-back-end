package ru.samedov.polyathlonbackend.controller;

import org.springframework.web.bind.annotation.*;
import ru.samedov.polyathlonbackend.domain.Manager;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    private static final List<Manager> MANAGERS = Arrays.asList(
      new Manager(1L, "Trusov"),
      new Manager(2L, "Samedov")
    );

    @GetMapping(path = "{managerId)")
    public Manager getUser(@PathVariable Long managerId) {
        return MANAGERS.stream()
                .filter(manager -> managerId.equals(manager.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Manager " + managerId + " does not exists"));
    }
}
