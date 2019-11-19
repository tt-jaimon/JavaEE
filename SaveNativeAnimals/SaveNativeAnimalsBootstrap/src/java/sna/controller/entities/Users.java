/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.controller.entities;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import sna.repository.entities.Roles;

/**
 *
 * @author Jaimon TT
 */
@RequestScoped
@Named(value = "user")
public class Users implements Serializable {    

    private int userID;
    private Roles roleID;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String address;
    private String emailID;
    private String password;

    public Users() {
    }

    public Users(int userID, Roles roleID, String firstName, String lastName, String password, String mobileNo, String address, String emailID) {
        this.userID = userID;
        this.roleID = roleID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.mobileNo = mobileNo;
        this.address = address;
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public Roles getRoleID() {
        return roleID;
    }

    public void setRoleID(Roles roleID) {
        this.roleID = roleID;
    }
     
}
