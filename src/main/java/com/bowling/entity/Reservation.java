package com.bowling.entity;

/**
 * Created by Akronys on 21/02/2015.
 */

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @Column
    private String nameReservation;

    public String getNameReservation() {
        return nameReservation;
    }

    public void setNameReservation(String nameReservation) {
        this.nameReservation = nameReservation;
    }

    public int getCountPlayer() {
        return countPlayer;
    }

    public void setCountPlayer(int countPlayer) {
        this.countPlayer = countPlayer;
    }

    public int getCountGame() {
        return countGame;
    }

    public void setCountGame(int countGame) {
        this.countGame = countGame;
    }

    @Column
    private int countPlayer;

    @Column
    private int countGame;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Game.class)
    private List<Game> games;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = Player.class)
    private List<Player> players;

    @Column(columnDefinition="DATETIME")
    private Date startReservation;

    @Column(columnDefinition="DATETIME")
    private Date  endReservation;

    public Reservation(){}

    public Reservation(String nameReservation, int countGame, int countPlayer) {
        this.nameReservation = nameReservation;
        this.countGame = countGame;
        this.countPlayer = countPlayer;
    }

    public Reservation(Date startReservation, String nameReservation, int countGame, int countPlayer) {
        this.startReservation = startReservation;
        this.nameReservation = nameReservation;
        this.countGame = countGame;
        this.countPlayer = countPlayer;
    }


    private int calculatePlayingTime(){
        int averageTimeByPlayerByGame = 510; // En secondes
        return this.countPlayer * averageTimeByPlayerByGame * this.countGame;
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
        setEndReservation();
    }

    public Date getEndReservation() {
        return endReservation;
    }

    public void setEndReservation() {
        /* TODO : Calculate endRservation from startReservation  */
        int duration = calculatePlayingTime();

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