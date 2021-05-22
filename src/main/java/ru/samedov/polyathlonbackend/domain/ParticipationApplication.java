package ru.samedov.polyathlonbackend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ParticipationApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String university;

    private Long eventId;

    @ManyToOne
    private User creator;

    @OneToMany
    private List<Sportsman> sportsmen;

    public ParticipationApplication() {
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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
}
