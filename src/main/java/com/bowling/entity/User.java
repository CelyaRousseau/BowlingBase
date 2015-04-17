package com.bowling.entity;

/**
 * Created by Akronys on 21/02/2015.
 */

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="role",
        discriminatorType= DiscriminatorType.STRING)
@DiscriminatorValue(value="user")
public class User implements Serializable{

    @Id
    @GeneratedValue
    @Column
    private int id;

    @NotNull
    @Column(updatable = false)
    private String firstName;

    @NotNull
    @Column(updatable = false)
    private String lastName;

    public User(){

    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}