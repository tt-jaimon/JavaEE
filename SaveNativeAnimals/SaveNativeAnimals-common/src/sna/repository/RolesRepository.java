/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository;

import java.util.List;
import javax.ejb.Remote;
import sna.repository.entities.Roles;

/**
 *
 * @author Jaimon TT
 */
@Remote
public interface RolesRepository {
    
    public void addRoles(Roles role) throws Exception;
    
    public void editRoles(Roles role) throws Exception;
    
    public void removeRoles(int roleID) throws Exception;
    
    public List<Roles> getAllRoles() throws Exception;
    
    public Roles searchRoleById(int roleID) throws Exception;    
    
}
