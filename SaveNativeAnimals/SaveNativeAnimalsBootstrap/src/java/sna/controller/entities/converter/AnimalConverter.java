/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.controller.entities.converter;

import java.util.List;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import sna.mbeans.AnimalManagedBean;
import sna.repository.entities.Animal;

/**
 *
 * @author Jaimon TT
 */
@FacesConverter(forClass = Animal.class,value="animal")
 
 public class AnimalConverter implements Converter{
    @ManagedProperty(value="#{animalManagedBean}") 
    AnimalManagedBean animalManagedBean;
    
    public List<Animal> animalDB; //= propertyManagedBean.getAllContactPeople();

    public AnimalConverter() 
    {
        try
        {
            //instantiate rolesManagedBean
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            animalManagedBean = (AnimalManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "animalManagedBean");

            animalDB = animalManagedBean.getAllAnimals();
        }
        catch(Exception ex)
        {
            
        }
    }
                       
    //this method is for converting the submittedValue (here it means the contact person id) to the contact person object
    //the reason for using this method is, the dropdown box in the xhtml does not capture the contact person object, but the id.
    public Animal getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (Animal animal : animalDB) {
                    if (animal.getAnimalID()== number) {
                        return animal;
                    }
                }

            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid role person"));
            }
        }

        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Animal) value).getAnimalID());
        }
    }
    
}
