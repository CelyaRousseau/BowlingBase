package com.bowling.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Akronys on 21/02/2015.
 */

@Entity
@Table(name = "game")
public class Game implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Score.class)
    @JoinColumn(name = "game_id")
    private List<Score> scores;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Lane.class)
    private Lane lane;

    @Column
    private int totalRounds;

    @Column
    private int currentRound;

    public Game(){};

    public Game(int totalRounds, Lane lane){
        this.totalRounds = totalRounds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(int round) {
        this.totalRounds = round;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int remainingRounds) {
        this.currentRound = remainingRounds;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
