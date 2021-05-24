package ru.samedov.polyathlonbackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ParticipationApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String university;

    @ManyToOne
    private User creator;

    @OneToMany
    private List<Sportsman> sportsmen;

    @ManyToOne
    @JsonBackReference
    private Event event;

    public ParticipationApplication() {
    }

    public ParticipationApplication(long id, String university) {
        this.id = id;
        this.university = university;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Sportsman> getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(List<Sportsman> sportsmen) {
        this.sportsmen = sportsmen;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
