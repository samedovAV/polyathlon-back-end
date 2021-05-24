package ru.samedov.polyathlonbackend.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    private String title;

    private String description;

    private LocalDate date;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "event",
            cascade = CascadeType.ALL)
    private List<Sportsman> sportsmanList;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "event",
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ParticipationApplication> applicationList;

    @ManyToOne
    private User creator;

    public Event() {
    }

    public Event(Long id, String title, String description, LocalDate date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Sportsman> getSportsmanList() {
        return sportsmanList;
    }

    public void setSportsmanList(List<Sportsman> sportsmanList) {
        this.sportsmanList = sportsmanList;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void addSportsman(Sportsman sportsman) {
        sportsmanList.add(sportsman);
    }

    public List<ParticipationApplication> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<ParticipationApplication> applicationList) {
        this.applicationList = applicationList;
    }
}
