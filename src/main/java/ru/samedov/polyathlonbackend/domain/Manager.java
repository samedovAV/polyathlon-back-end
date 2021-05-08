package ru.samedov.polyathlonbackend.domain;

public class Manager {

    private Long id;

    private String login;

    public Manager(Long id, String login) {
        this.id = id;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
