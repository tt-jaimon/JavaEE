/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository;

import java.util.List;
import javax.ejb.Remote;
import sna.repository.entities.Sponsors;

/**
 *
 * @author Jaimon TT
 */
@Remote
public interface SponsorsRepository {
    
    public void addSponsor(Sponsors role) throws Exception;
    
    public void editSponsor(Sponsors role) throws Exception;
    
    public void removeSponsor(int sponsorsID) throws Exception;
    
    public List<Sponsors> getAllSponsor() throws Exception;
    
    public Sponsors searchSponsorById(int sponsorsID) throws Exception;    
    
}
