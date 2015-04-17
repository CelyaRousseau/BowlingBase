package com.bowling.entity;

/**
 * Created by Akronys on 21/02/2015.
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lane")
public class Lane implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private boolean hasRail;

    public Lane(){};

    public Lane(String name, boolean hasRail) {
        this.name = name;
        this.hasRail = hasRail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getHasRail() {
        return hasRail;
    }

    public void setHasRail(boolean hasRail) {
        this.hasRail = hasRail;
    }
}
