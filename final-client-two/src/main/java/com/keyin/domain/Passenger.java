
package com.keyin.domain;

import com.keyin.Aircraft.Aircraft;

import javax.persistence.*;
import java.util.List;

//@Entity
public class Passenger {

    //@Id
    //@SequenceGenerator(name = "passenger_sequence", sequenceName = "passenger_sequence", allocationSize = 1, initialValue=1)
    //@GeneratedValue(generator = "passenger_sequence")
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // relationships
    //@ManyToMany
    private List<Aircraft> aircraft;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

}
