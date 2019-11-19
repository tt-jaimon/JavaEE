/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.controller.entities;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author Jaimon TT
 */
@RequestScoped
@Named(value = "role")
public class Roles implements Serializable {


    private int roleID;
    private String roleName;

    public Roles() {
    }

    public Roles(int roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }
    
    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
}
