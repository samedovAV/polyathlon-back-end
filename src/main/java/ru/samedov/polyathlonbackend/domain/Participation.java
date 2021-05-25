package ru.samedov.polyathlonbackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int result;

    @ManyToOne
    @JsonBackReference
    private Sportsman sportsman;

    public Participation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }
}
