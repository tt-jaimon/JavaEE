/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.controllers.search;

import java.util.Map;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sna.mbeans.AnimalManagedBean;
import sna.controller.entities.Animal;

/**
 *
 * @author Jaimon TT
 */
@Named(value = "animalSearchController")
@RequestScoped
public class AnimalSearchController{
    @ManagedProperty(value="#{animalManagedBean}") 
    AnimalManagedBean animalManagedBean;

    private Animal animal;
    private String regionID;
    
    public AnimalSearchController() {
        
        animal = new Animal();
        regionID = null;
        Map<String, String> parameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if(parameterMap.get("animalName") != null){
            animal.setAnimalName(parameterMap.get("animalName"));
        }
        if(parameterMap.get("animalDescription") != null){
            animal.setAnimalDescription(parameterMap.get("animalDescription"));
        }
         
        if(parameterMap.get("regionID") != null){
            regionID = parameterMap.get("regionID");
        }
        
    }

    public String getRegionID() {
        return regionID;
    }
    

    public Animal getAnimal() {
        return animal;
    }
    
}