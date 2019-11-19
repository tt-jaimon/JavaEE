/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.controller.entities;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import sna.repository.entities.Events;


/**
 *
 * @author Jaimon TT
 */
@RequestScoped
@Named(value = "sponsor")
public class Sponsors implements Serializable  {

    private int sponsorID;
    private String sponsorName;
    private String sponsorDescription;
    private Set<Events> events;

    public Sponsors() {
    }

    public Sponsors(int sponsorID, String sponsorName, String sponsorDescription, Set<Events> events) {
        this.sponsorID = sponsorID;
        this.sponsorName = sponsorName;
        this.sponsorDescription = sponsorDescription;
        this.events = events;
    }

    public int getSponsorID() {
        return sponsorID;
    }

    public void setSponsorID(int sponsorID) {
        this.sponsorID = sponsorID;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getSponsorDescription() {
        return sponsorDescription;
    }

    public void setSponsorDescription(String sponsorDescription) {
        this.sponsorDescription = sponsorDescription;
    }

    public Set<Events> getEvents() {
        return events;
    }

    public void setEvents(Set<Events> events) {
        this.events = events;
    }

    
    
}
