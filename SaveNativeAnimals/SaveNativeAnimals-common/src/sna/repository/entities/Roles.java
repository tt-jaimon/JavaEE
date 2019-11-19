/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jaimon TT
 */
@Entity
@Table(name = "ROLES")
@NamedQueries({@NamedQuery(name = Roles.GET_ALL_QUERY_NAME, query = "SELECT c FROM Roles c")})
public class Roles implements Serializable {


    public static final String GET_ALL_QUERY_NAME = "Roles.getAll";
    
    @Id
    @GeneratedValue
    private int roleID;
    private String roleName;
    @OneToMany(mappedBy = "roleID")
    private Set<Users> users;
    

    public Roles() {
    }

    public Roles(int roleID, String roleName) {
        this.roleID = roleID;
        this.roleName = roleName;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
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
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Roles other = (Roles) obj;
        if (this.roleID != other.roleID) {
            return false;
        }
        return true;
    }
    
}
