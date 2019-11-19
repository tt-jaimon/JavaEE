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
import sna.mbeans.RolesManagedBean;
import sna.repository.entities.Roles;

/**
 *
 * @author Jaimon TT
 */
@FacesConverter(forClass = Roles.class,value="role")
 
 public class RolesConverter implements Converter{
    @ManagedProperty(value="#{rolesManagedBean}") 
    RolesManagedBean rolesManagedBean;
    
    public List<Roles> rolesDB; //= propertyManagedBean.getAllContactPeople();

    public RolesConverter() 
    {
        try
        {
            //instantiate rolesManagedBean
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            rolesManagedBean = (RolesManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "rolesManagedBean");

            rolesDB = rolesManagedBean.getAllRoles();
        }
        catch(Exception ex)
        {
            
        }
    }
                       
    //this method is for converting the submittedValue (here it means the contact person id) to the contact person object
    //the reason for using this method is, the dropdown box in the xhtml does not capture the contact person object, but the id.
    public Roles getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (Roles role : rolesDB) {
                    if (role.getRoleID()== number) {
                        return role;
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
            return String.valueOf(((Roles) value).getRoleID());
        }
    }
    
}
