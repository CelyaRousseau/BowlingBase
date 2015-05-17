package com.bowling.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Akronys on 21/02/2015.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="role",
        discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue(value="PLAYER")
public class Player extends User implements Serializable {

        @Column
        private String nickName;


        @JsonManagedReference
        @OneToMany(fetch = FetchType.EAGER, targetEntity = Score.class)
        @JoinColumn(name = "player_id")
        private List<Score> scores;

        public Player(){

        }

        public Player(String firstName, String lastName) {
                super(firstName, lastName);
        }


        public List<Score> getScores() {
            return scores;
        }

        public void setScores(List<Score> scores) {
            this.scores = scores;
        }

        public String getNickName() {
                return nickName;
        }

        public void setNickName(String nickName) {
                this.nickName = nickName;
        }
}
