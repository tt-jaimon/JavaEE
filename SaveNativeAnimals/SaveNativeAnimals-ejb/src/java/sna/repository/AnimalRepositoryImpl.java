/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import sna.repository.entities.Animal;
import sna.repository.entities.Region;

/**
 *
 * @author Jaimon TT
 */

@Stateless
public class AnimalRepositoryImpl implements AnimalRepository  {
    
    @PersistenceContext(unitName = "SaveNativeAnimals-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addAnimal(Animal animal) throws Exception {
        entityManager.persist(animal);
    }

    @Override
    public void editAnimal(Animal animal) throws Exception {
        entityManager.merge(animal);
    }

    @Override
    public void removeAnimal(int animalID) throws Exception {
        Animal animal = this.searchAnimalById(animalID);

        if (animal != null) {
            entityManager.remove(animal);
        }    
    }
    
    @Override
    public List<Animal> advancedSearch(Animal animal) throws Exception{
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Animal.class);
        Root<Animal> a = query.from(Animal.class);
        List<Predicate> predList = new ArrayList<Predicate>();
        if(animal.getAnimalName() !=null && animal.getAnimalName() !=""){
            Predicate temp = builder.and(builder.equal(a.get("animalName"), animal.getAnimalName()));
            predList.add(temp);
        }
        if(animal.getAnimalDescription() != null&& animal.getAnimalDescription() != ""){
            Predicate temp = builder.and(builder.equal(a.get("animalDescription"), animal.getAnimalDescription()));
            predList.add(temp);
        }
        if(animal.getRegionID() != null){
            Predicate temp = builder.and(builder.equal(a.get("regionID"), animal.getRegionID()));
            predList.add(temp);
        }
        query.select(a);
        if(predList.size() > 0)
        {
            Predicate[] predArray = new Predicate[predList.size()];
            predList.toArray(predArray);
            query.where(predArray);

        }
        List<Animal> lp = entityManager.createQuery(query).getResultList();
        return lp;
    }

    @Override
    public List<Animal> getAllAnimals() throws Exception {
        return entityManager.createNamedQuery(Animal.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Animal searchAnimalById(int animalID) throws Exception {
        Animal animal = entityManager.find(Animal.class, animalID);
        return animal;    
    }
    
    @Override
    public Set<Animal> searchAnimalsByRegionID(int regionID) throws Exception {
        Region region = entityManager.find(Region.class, regionID);
        region.getAnimals().size();
        entityManager.refresh(region);

        return region.getAnimals();
    }
    
    
}
