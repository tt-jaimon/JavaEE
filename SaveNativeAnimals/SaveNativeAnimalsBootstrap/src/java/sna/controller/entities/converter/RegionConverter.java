/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.controller.entities.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import sna.mbeans.RegionManagedBean;
import sna.repository.entities.Region;

/**
 *
 * @author Jaimon TT
 */
@FacesConverter(forClass = Region.class,value="region")
 
 public class RegionConverter implements Converter{
    @ManagedProperty(value="#{regionManagedBean}") 
    RegionManagedBean regionManagedBean;
    
    public List<Region> regionDB; //= propertyManagedBean.getAllContactPeople();

    public RegionConverter() 
    {
        try
        {
            //instantiate rolesManagedBean
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            regionManagedBean = (RegionManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "regionManagedBean");

            regionDB = regionManagedBean.getAllRegions();
        }
        catch(Exception ex)
        {
            
        }
    }
                       
    //this method is for converting the submittedValue (here it means the contact person id) to the contact person object
    //the reason for using this method is, the dropdown box in the xhtml does not capture the contact person object, but the id.
    public Region getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (Region region : regionDB) {
                    if (region.getRegionID()== number) {
                        return region;
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
            Set<Object> temp = new HashSet<Object>();
            temp.add(value);
            return String.valueOf(((Region) value).getRegionID());
        }
    }
    
}
