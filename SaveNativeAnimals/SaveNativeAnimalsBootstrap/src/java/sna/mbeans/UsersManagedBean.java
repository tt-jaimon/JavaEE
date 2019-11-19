/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.mbeans;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sna.repository.UsersRepository;
import sna.repository.entities.Users;

/**
 *
 * @author Jaimon TT
 */
@ManagedBean(name = "usersManagedBean")
@SessionScoped
public class UsersManagedBean implements Serializable{
        
    @EJB
    UsersRepository usersRepository;


    public UsersManagedBean() {
    }
    
     public boolean isRquiredEntitiesNotMissing(Users user){
        if(user.getEmailID()== null ||user.getFirstName()== null|| user.getLastName()== null || user.getMobileNo() == null
                ||user.getPassword() == null || user.getRoleID() == null ||user.getEmailID()== "" ||user.getFirstName()== ""
                || user.getLastName()== "" || user.getMobileNo() == ""||user.getPassword() == "" ){
            return false;
        }
        return true;
    }
    
    public String addMainUser(Users user){
         try {
                if(isRquiredEntitiesNotMissing(user)){
                   usersRepository.addUser(user);
                }
               return "/admin/view/users.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    
    public String addUser(sna.controller.entities.Users localUser){
          Users user = convertUserToEntity(localUser);
          return addMainUser(user);
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String getSHA256EncryptedPassword(String password){
        try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(password.getBytes("UTF-8"));
                StringBuffer hexString = new StringBuffer();

                for (int i = 0; i < hash.length; i++) {
                    String hex = Integer.toHexString(0xff & hash[i]);
                    if(hex.length() == 1) hexString.append('0');
                    hexString.append(hex);

                }
                password =  hexString.toString();

            }catch (Exception ex) {
                Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        return password;
    }
    public Users convertUserToEntity(sna.controller.entities.Users localUser){
        Users user = new Users();
        user.setAddress(localUser.getAddress());
        user.setEmailID(localUser.getEmailID());
        user.setFirstName(localUser.getFirstName());
        user.setLastName(localUser.getLastName());
        user.setMobileNo(localUser.getMobileNo());
        user.setRoleID(localUser.getRoleID());
        user.setUserID(localUser.getUserID());
        user.setPassword(getSHA256EncryptedPassword(localUser.getPassword()));
        return user;
    }
    
    public String redirectToUsersViewPage(int id,boolean isAdmin){
        if(isAdmin){
            return "/admin/view/viewUser.xhtml?faces-redirect=true&userID=" + id;
        }
        return "/public/view/viewUser.xhtml?faces-redirect=true&userID=" + id;
    }
    
    public String editUser(Users user,boolean isAdmin)
    {
        try {
            if(isRquiredEntitiesNotMissing(user)){
                   usersRepository.editUser(user);
                }
            return redirectToUsersViewPage(user.getUserID(), isAdmin);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String removeUser(int id){
        try {
            usersRepository.removeUser(id);
            return "/admin/view/users.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public List<Users> getAllUsers() {
        try {
            return usersRepository.getAllUsers();
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Users searchUserById(int id)
    {
        try {
            return usersRepository.searchUserById(id);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
