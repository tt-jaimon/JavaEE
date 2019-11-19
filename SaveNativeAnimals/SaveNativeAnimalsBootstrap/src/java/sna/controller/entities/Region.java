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
import sna.repository.entities.Animal;

/**
 *
 * @author Jaimon TT
 */

@RequestScoped
@Named(value = "region")
public class Region implements Serializable {
    
    private int regionID;
    private String regionName;
    private String regionDescription;
    
    private Object animals;

    public Region() {
    }

    public Region(int regionID, String regionName, String regionDescription, Set<Animal> animals) {
        this.regionID = regionID;
        this.regionName = regionName;
        this.regionDescription = regionDescription;
        this.animals = animals;
    }

    public Object getAnimals() {
        return animals;
    }

    public void setAnimals(Object animals) {
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

    
}
