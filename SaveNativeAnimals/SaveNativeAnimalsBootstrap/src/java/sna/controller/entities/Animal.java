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
import sna.repository.entities.Region;

/**
 *
 * @author Jaimon TT
 */
@RequestScoped
@Named(value = "animal")
public class Animal implements Serializable {
    
    
    private int animalID;
    private String animalName;
    private String animalDescription;
    
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

    

    

    

    
}
