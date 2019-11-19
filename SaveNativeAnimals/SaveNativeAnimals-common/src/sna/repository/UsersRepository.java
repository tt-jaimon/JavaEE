/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository;

import java.util.List;
import javax.ejb.Remote;
import sna.repository.entities.Users;

/**
 *
 * @author Jaimon TT
 */
@Remote
public interface UsersRepository {
    
    public void addUser(Users user) throws Exception;
    
    public void editUser(Users user) throws Exception;
    
    public void removeUser(int userID) throws Exception;
    
    public List<Users> getAllUsers() throws Exception;
    
    public Users searchUserById(int userID) throws Exception; 
}
