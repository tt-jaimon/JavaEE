/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sna.repository.entities.Roles;

/**
 *
 * @author Jaimon TT
 */
@Stateless
public class RolesRepositoryImpl implements RolesRepository{
    
    @PersistenceContext(unitName = "SaveNativeAnimals-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addRoles(Roles role) throws Exception {
        entityManager.persist(role);
    }

    @Override
    public void editRoles(Roles role) throws Exception {
        entityManager.merge(role);
    }

    @Override
    public void removeRoles(int roleID) throws Exception {
        Roles role = this.searchRoleById(roleID);

        if (role != null) {
            entityManager.remove(role);
        }    
    }

    @Override
    public List<Roles> getAllRoles() throws Exception {
        return entityManager.createNamedQuery(Roles.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Roles searchRoleById(int roleID) throws Exception {
        Roles role = entityManager.find(Roles.class, roleID);
        return role;    
    }
    
}
