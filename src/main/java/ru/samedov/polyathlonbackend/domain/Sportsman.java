package ru.samedov.polyathlonbackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Sportsman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private int yearOfBirth;

    // todo calc age
    private int age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sportsman")
    @JsonManagedReference
    private List<Participation> participationList;

    @ManyToOne (fetch=FetchType.LAZY,
            cascade=CascadeType.ALL)
    @JoinColumn (name="event_id")
    @JsonBackReference
    private Event event;

    public Sportsman() {
    }

    public Sportsman(String firstName, String lastName, int yearOfBirth, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Participation> getParticipationList() {
        return participationList;
    }

    public void setParticipationList(List<Participation> participationList) {
        this.participationList = participationList;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
