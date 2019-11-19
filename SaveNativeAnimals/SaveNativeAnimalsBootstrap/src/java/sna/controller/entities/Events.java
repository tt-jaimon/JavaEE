/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.controller.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import sna.repository.entities.Region;
import sna.repository.entities.Sponsors;
import sna.repository.entities.Animal;


/**
 *
 * @author Jaimon TT
 */
@RequestScoped
@Named(value = "event")
public class Events implements Serializable {

    
    private int eventID;
    private String eventName;
    private String eventDescription;
    private Region regionID;
    private Animal animalID;
    private Date startingDate;
    private Date endingDate;
    private Sponsors sponsorID;

    public Events() {
    }

    public Events(int eventID, String eventName, String eventDescription, Region regionID, Animal animalID, Date startingDate, Date endingDate, Sponsors sponsorID) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.regionID = regionID;
        this.animalID = animalID;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.sponsorID = sponsorID;
    }

    

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate =startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Sponsors getSponsorID() {
        return sponsorID;
    }

    public void setSponsorID(Sponsors sponsorID) {
        this.sponsorID = sponsorID;
    }

    public Region getRegionID() {
        return regionID;
    }

    public void setRegionID(Region regionID) {
        this.regionID = regionID;
    }

    public Animal getAnimalID() {
        return animalID;
    }

    public void setAnimalID(Animal animalID) {
        this.animalID = animalID;
    }

    
    
    
}
