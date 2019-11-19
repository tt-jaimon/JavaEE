/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository;

import java.util.List;
import java.util.Set;
import javax.ejb.Remote;
import sna.repository.entities.Animal;
import sna.repository.entities.Region;
/**
 *
 * @author Jaimon TT
 */
@Remote
public interface AnimalRepository {
    
    public void addAnimal(Animal animal) throws Exception;
    
    public void editAnimal(Animal animal) throws Exception;
    
    public void removeAnimal(int animalID) throws Exception;
    
    public List<Animal> getAllAnimals() throws Exception;
    
    public Animal searchAnimalById(int animalID) throws Exception;
    
    public List<Animal> advancedSearch(Animal animal) throws Exception;
        
    public Set<Animal> searchAnimalsByRegionID(int regionID) throws Exception;
    
}
