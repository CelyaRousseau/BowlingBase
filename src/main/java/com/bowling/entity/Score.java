package com.bowling.entity;

/**
 * Created by Akronys on 21/02/2015.
 */

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score")
public class Score implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int round;

    @Column
    private int firstRoll;

    @Column
    private int secondRoll;

    @Column
    private  int RoundPoints;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Player.class)
    private Player player;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Game.class)
    private Game game;

    public Score(){};

    public Score(int round, Player player, Game game) {
        this.round = round;
        this.player = player;
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int currentRound) {
        this.round = currentRound;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public int getRoundPoints() {
        return RoundPoints;
    }

    public void setRoundPoints(int roundPoints) {
        RoundPoints = roundPoints;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
