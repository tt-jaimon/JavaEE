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
import javax.persistence.JoinTable;
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
@Table(name = "REGION")
@NamedQueries({@NamedQuery(name = Region.GET_ALL_QUERY_NAME, query = "SELECT c FROM Region c")})
public class Region implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Region.getAll";
    
    @Id
    @GeneratedValue
    private int regionID;
    private String regionName;
    private String regionDescription;
    
    @OneToMany(mappedBy = "regionID")
    private Set<Animal> animals;

    public Region() {
    }

    public Region(int regionID, String regionName, String regionDescription, Set<Animal> animals) {
        this.regionID = regionID;
        this.regionName = regionName;
        this.regionDescription = regionDescription;
        this.animals = animals;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public boolean equals(Object obj) {
                
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Region other = (Region) obj;
        if (this.regionID != other.regionID) {
            return false;
        }
        return true;
    }

    
    


    
}
