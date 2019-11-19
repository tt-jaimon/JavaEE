/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jaimon TT
 */
@Entity
@Table(name = "USERS")
@NamedQueries({@NamedQuery(name = Users.GET_ALL_QUERY_NAME, query = "SELECT c FROM Users c")})
public class Users implements Serializable {

    public static final String GET_ALL_QUERY_NAME = "Users.getAll";
    
    @Id
    @GeneratedValue
    private int userID;
    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    private Roles roleID;
    private String firstName;
    private String lastName;
    private String password;
    private String mobileNo;
    private String address;
    private String emailID;

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
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }
     
}
