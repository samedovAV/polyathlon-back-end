package ru.samedov.polyathlonbackend.errors;

public class SportsmanNotFoundException extends RuntimeException {

    public SportsmanNotFoundException(Long id) {
        super("Could not find sportsman: " + id);
    }
}
