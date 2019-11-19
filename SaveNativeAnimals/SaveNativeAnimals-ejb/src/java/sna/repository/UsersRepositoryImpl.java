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
import sna.repository.entities.Users;

/**
 *
 * @author Jaimon TT
 */

@Stateless
public class UsersRepositoryImpl implements UsersRepository{
    
    @PersistenceContext(unitName = "SaveNativeAnimals-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addUser(Users user) throws Exception {
        entityManager.persist(user);
    }

    @Override
    public void editUser(Users user) throws Exception {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(int userID) throws Exception {
        Users user = this.searchUserById(userID);

        if (user != null) {
            entityManager.remove(user);
        }    
    }

    @Override
    public List<Users> getAllUsers() throws Exception {
        return entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Users searchUserById(int userID) throws Exception {
        Users user = entityManager.find(Users.class, userID);
        return user;    
    }
    
    
}
