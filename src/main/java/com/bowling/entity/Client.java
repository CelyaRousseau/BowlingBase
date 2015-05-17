package com.bowling.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Akronys on 21/02/2015.
 */

@Entity
@DiscriminatorValue(value = "CLIENT")
public class Client extends Player implements Serializable{

    @Column
    private String email;

    @Column
    private String password;

    public Client() {
    }

    public Client(String firstName, String lastName, String email, String password) {
        super(firstName, lastName);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
