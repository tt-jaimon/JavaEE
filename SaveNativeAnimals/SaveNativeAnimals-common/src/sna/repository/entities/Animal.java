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
@Table(name = "ANIMAL")
@NamedQueries({@NamedQuery(name = Animal.GET_ALL_QUERY_NAME, query = "SELECT c FROM Animal c")})
public class Animal implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Animal.getAll";
    
    @Id
    @GeneratedValue
    private int animalID;
    private String animalName;
    private String animalDescription;
    
    @ManyToOne
    @JoinColumn(name = "region_id",nullable = true)
    private Region regionID;

    public Animal() {
    }

    public Animal(int animalID, String animalName, String animalDescription, Region regionID) {
        this.animalID = animalID;
        this.animalName = animalName;
        this.animalDescription = animalDescription;
        this.regionID = regionID;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalDescription() {
        return animalDescription;
    }

    public void setAnimalDescription(String animalDescription) {
        this.animalDescription = animalDescription;
    }

    public Region getRegionID() {
        return regionID;
    }

    public void setRegionID(Region regionID) {
        this.regionID = regionID;
    }

    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.animalID != other.getAnimalID()) {
            return false;
        }
        return true;
    }
    
    
}
