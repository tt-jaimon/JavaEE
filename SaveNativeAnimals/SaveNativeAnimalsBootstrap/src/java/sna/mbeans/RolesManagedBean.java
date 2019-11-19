/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.mbeans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sna.repository.RolesRepository;
import sna.repository.entities.Roles;
import sna.repository.entities.Users;

/**
 *
 * @author Jaimon TT
 */
@ManagedBean(name = "rolesManagedBean")
@SessionScoped
public class RolesManagedBean  implements Serializable{
    @EJB
    RolesRepository rolesRepository;


    public RolesManagedBean() {
    }
    
    public boolean isRquiredEntitiesNotMissing(Roles role){
        if(role.getRoleName()== null || role.getRoleName()== ""){
            return false;
        }
        return true;
    }
    
    public String addMainRole(Roles role){
         try {
                if(isRquiredEntitiesNotMissing(role)){
                    rolesRepository.addRoles(role);
                }
               return "/admin/view/users.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(RolesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    
    public String addRole(sna.controller.entities.Roles localVariable){
          Roles role = convertRoleToEntity(localVariable);
          return addMainRole(role);
    }
    
     public Roles convertRoleToEntity(sna.controller.entities.Roles localVariable){
        Roles role = new Roles();
        role.setRoleID(localVariable.getRoleID());
        role.setRoleName(localVariable.getRoleName());
        return role;
    }
     
    public void editRole(Roles role)
    {
        try {
            if(isRquiredEntitiesNotMissing(role)){
                    rolesRepository.editRoles(role);
                }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Role has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(RolesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String removeRole(int id){
        try {
            rolesRepository.removeRoles(id);
            return "/admin/view/roles.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(RolesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public List<Roles> getAllRoles() {
        try {
            return rolesRepository.getAllRoles();
        } catch (Exception ex) {
            Logger.getLogger(RolesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Roles searchRoleById(int id)
    {
        try {
            return rolesRepository.searchRoleById(id);
        } catch (Exception ex) {
            Logger.getLogger(RolesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
