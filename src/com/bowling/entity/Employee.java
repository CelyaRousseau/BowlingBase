package com.bowling.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Akronys on 21/02/2015.
 */

@Entity
@Table(name="user")
@DiscriminatorValue(value = "EMPLOYEE")
public class Employee extends User implements Serializable{

    @Column
    private int code;

    public Employee(){

    }

    public Employee(String firstName, String lastName, int code) {
        super(firstName, lastName);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
