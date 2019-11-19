package sna.controllers;

import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import sna.mbeans.AnimalManagedBean;
import sna.repository.entities.Animal;

/**
 *
 * @author Jaimon TT
 */
@Named(value = "animalController")
@RequestScoped
public class AnimalController{
    @ManagedProperty(value="#{animalManagedBean}") 
    AnimalManagedBean animalManagedBean;

    private int animalID; 
    private Animal animal;
    
    public AnimalController() {
        animalID = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("animalID"));
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            animalManagedBean = (AnimalManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "animalManagedBean");
        animal = animalManagedBean.searchAnimalById(animalID);
    }

    public Animal getAnimal() {
        return animal;
    }
    
}
