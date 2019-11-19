/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sna.repository.AnimalRepository;
import sna.repository.RegionRepository;
import sna.repository.entities.Animal;
import sna.repository.entities.Region;

/**
 *
 * @author Jaimon TT
 */
@ManagedBean(name = "animalManagedBean" )
@SessionScoped
public class AnimalManagedBean implements Serializable{
        
    @EJB
    AnimalRepository animalRepository;
    
    @EJB
    RegionRepository regionRepository;

    public AnimalManagedBean() {
    }
    
    public boolean isRquiredEntitiesNotMissing(Animal animal){
        if(animal.getAnimalName() == null || animal.getAnimalName() == "" || animal.getAnimalDescription() == null
                || animal.getAnimalDescription() == ""|| animal.getRegionID() == null){
            return false;
        }
        return true;
    }
    
    public String addAnimal(sna.controller.entities.Animal localVariable,boolean isAdmin){
          Animal animal = convertAnimalToEntity(localVariable);
          return addMainAnimal(animal,isAdmin);
    }
    
    public List<Animal> advancedSearch(sna.controller.entities.Animal localVariable,String regionID ){
        Animal animal = convertAnimalToEntity(localVariable);
        return advanceMainSearch(animal, regionID);
    }
    
    public List<Animal> advanceMainSearch(Animal animal,String regionID){
         try {
                if(regionID != null && regionID != ""){
                    Region region = regionRepository.searchRegionById(Integer.valueOf(regionID).intValue());
                    animal.setRegionID(region);
                }
               return animalRepository.advancedSearch(animal);
        } catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
    public String redirectToAnimalsViewPage(int id,boolean isAdmin){
        if(isAdmin){
            return "/admin/view/viewAnimal.xhtml?faces-redirect=true&animalID=" + id;
        }
        return "/public/view/viewAnimal.xhtml?faces-redirect=true&animalID=" + id;
    }
    
    public String redirectToAnimalsAdvancedFilter(sna.controller.entities.Animal localVariable,boolean isAdmin){
        String res = "";
        if(isAdmin){
            res = "/admin/view/searchAnimals.xhtml?faces-redirect=true";
        }
        else{
            res = "/public/view/searchAnimals.xhtml?faces-redirect=true";
        }
        if(localVariable.getRegionID() != null)
            {
                res += "&regionID=" + localVariable.getRegionID().getRegionID();
            }
            if(localVariable.getAnimalName()!=null){
                res+= "&animalName=" + localVariable.getAnimalName();
            }
            if(localVariable.getAnimalDescription()!=null){
                res+= "&animalDescription=" + localVariable.getAnimalDescription();
            }
            return res;
    }
    
    public Integer getRegionID(sna.controller.entities.Animal localVariable){
        return null;
    }
    
    public String addMainAnimal(Animal animal,boolean isAdmin){

         try {
            if(isRquiredEntitiesNotMissing(animal)){
                animalRepository.addAnimal(animal);
            }
               if(isAdmin){
                   return "/admin/view/animals.xhtml?faces-redirect=true";
               }
               return "/public/view/animals.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    
     public Animal convertAnimalToEntity(sna.controller.entities.Animal localVariable){
        Animal animal = new Animal();
        animal.setAnimalID(localVariable.getAnimalID());
        animal.setAnimalName(localVariable.getAnimalName());
        animal.setAnimalDescription(localVariable.getAnimalDescription());
        animal.setRegionID(localVariable.getRegionID());
        return animal;
    }
    
    public String editAnimal(Animal animal,boolean isAdmin)
    {
        try {
            if(isRquiredEntitiesNotMissing(animal)){
                animalRepository.editAnimal(animal);
            }
            return redirectToAnimalsViewPage(animal.getAnimalID(), isAdmin);
        } catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String removeAnimal(int id){
        try {
            animalRepository.removeAnimal(id);
            return "/admin/view/animals.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    

    public List<Animal> getAllAnimals() {
        try {
            return animalRepository.getAllAnimals();
        } catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Animal searchAnimalById(int id)
    {
        try {
            return animalRepository.searchAnimalById(id);
        } catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public List<Animal> searchAnimalByRegion(Integer regionID) 
    {
        if(regionID == null)
            {
                return null;
            }
        try {  
                List<Animal> animalsList = new ArrayList<Animal>();
                Set<Animal> animals = animalRepository.searchAnimalsByRegionID(regionID.intValue());
                if(animals != null){
                    animalsList.addAll(animals);
                }
                return animalsList;
        } catch (Exception ex) {
            Logger.getLogger(AnimalManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
