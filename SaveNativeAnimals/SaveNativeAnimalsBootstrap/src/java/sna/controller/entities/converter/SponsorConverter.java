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
import sna.mbeans.SponsorsManagedBean;
import sna.repository.entities.Sponsors;

/**
 *
 * @author Jaimon TT
 */
@FacesConverter(forClass = Sponsors.class,value="sponsor")
 
 public class SponsorConverter implements Converter{
    @ManagedProperty(value="#{sponsorsManagedBean}") 
    SponsorsManagedBean sponsorsManagedBean;
    
    public List<Sponsors> sponsorDB; //= propertyManagedBean.getAllContactPeople();

    public SponsorConverter() 
    {
        try
        {
            //instantiate rolesManagedBean
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            sponsorsManagedBean = (SponsorsManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "sponsorsManagedBean");

            sponsorDB = sponsorsManagedBean.getAllSponsors();
        }
        catch(Exception ex)
        {
            
        }
    }
                       
    //this method is for converting the submittedValue (here it means the contact person id) to the contact person object
    //the reason for using this method is, the dropdown box in the xhtml does not capture the contact person object, but the id.
    public Sponsors getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (Sponsors sponsor : sponsorDB) {
                    if (sponsor.getSponsorID()== number) {
                        return sponsor;
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
            return String.valueOf(((Sponsors) value).getSponsorID());
        }
    }
    
}
