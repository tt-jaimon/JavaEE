package sna.controllers;

import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import sna.mbeans.RolesManagedBean;
import sna.repository.entities.Roles;

/**
 *
 * @author Jaimon TT
 */
@Named(value = "roleController")
@RequestScoped
public class RoleController{
    @ManagedProperty(value="#{rolesManagedBean}") 
    RolesManagedBean rolesManagedBean;

    private int roleID; 
    private Roles role;
    

    public RoleController() {
        roleID = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("roleID"));
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            rolesManagedBean = (RolesManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "rolesManagedBean");
        role = rolesManagedBean.searchRoleById(roleID);
    }

    public Roles getRole() {
        return role;
    }

}
