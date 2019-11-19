/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jaimon TT
 */
@Entity
@Table(name = "EVENTS")
@NamedQueries({@NamedQuery(name = Events.GET_ALL_QUERY_NAME, query = "SELECT c FROM Events c")})
public class Events implements Serializable {

    public static final String GET_ALL_QUERY_NAME = "Events.getAll";    
    
    @Id
    @GeneratedValue
    private int eventID;
    private String eventName;
    @OneToOne
    @JoinColumn(name = "region_id",nullable = true)
    private Region regionID;
    @OneToOne
    @JoinColumn(name = "animal_id",nullable = true)
    private Animal animalID;
    private Date startingDate;
    private Date endingDate;
    private String eventDescription;
    
    @ManyToOne
    @JoinColumn(name = "sponsor_id",nullable = true)
    private Sponsors sponsorID;

    public Events() {
    }

    public Events(int eventID, String eventName, Region regionID, Animal animalID, Date startingDate, Date endingDate, String eventDescription, Sponsors sponsorID) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.regionID = regionID;
        this.animalID = animalID;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.eventDescription = eventDescription;
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
        this.startingDate = startingDate;
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

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Events other = (Events) obj;
        if (this.eventID != other.getEventID()) {
            return false;
        }
        return true;
    }
    
    
}
