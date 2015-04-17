package com.bowling.entity;

/**
 * Created by Akronys on 21/02/2015.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Game.class)
    @JoinColumn(name = "reservation_id")
    private List<Game> games;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Player.class)
    private List<Player> players;

    @Column
    private Date startReservation;

    @Column
    private Date endReservation;

    public Reservation(){}

    public Reservation(Date startReservation, List<Game> games, List<Player> players) {
        this.startReservation = startReservation;
        this.games = games;
    }

    public int getId() {
        return id;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Date getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(Date startReservation) {
        this.startReservation = startReservation;
    }

    public Date getEndReservation() {
        return endReservation;
    }

    public void setEndReservation(Date endReservation) {
        this.endReservation = endReservation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}