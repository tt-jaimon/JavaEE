/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jaimon TT
 */

@Entity
@Table(name = "SPONSORS")
@NamedQueries({@NamedQuery(name = Sponsors.GET_ALL_QUERY_NAME, query = "SELECT c FROM Sponsors c")})
public class Sponsors implements Serializable  {


    public static final String GET_ALL_QUERY_NAME = "Sponsors.getAll";
    
    @Id
    @GeneratedValue
    private int sponsorID;
    private String sponsorName;
    private String sponsorDescription;
    @OneToMany(mappedBy = "sponsorID")
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
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sponsors other = (Sponsors) obj;
        if (this.sponsorID != other.getSponsorID()) {
            return false;
        }
        return true;
    }

    
    
}
