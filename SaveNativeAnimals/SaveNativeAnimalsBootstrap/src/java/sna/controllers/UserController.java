package sna.controllers;

import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import sna.mbeans.UsersManagedBean;
import sna.repository.entities.Users;

/**
 *
 * @author Jaimon TT
 */
@Named(value = "userController")
@RequestScoped
public class UserController{
    @ManagedProperty(value="#{usersManagedBean}") 
    UsersManagedBean usersManagedBean;

    private int userID; 
    private Users user;
    

    public UserController() {
        userID = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("userID"));
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            usersManagedBean = (UsersManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "usersManagedBean");
        user = usersManagedBean.searchUserById(userID);
    }

    public Users getUser() {
        return user;
    }

   
    

}
