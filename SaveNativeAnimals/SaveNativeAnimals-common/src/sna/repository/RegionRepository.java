/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository;

import java.util.List;
import javax.ejb.Remote;
import sna.repository.entities.Region;

/**
 *
 * @author Jaimon TT
 */
@Remote
public interface RegionRepository {

    public void addRegion(Region region) throws Exception;
    
    public void editRegion(Region region) throws Exception;
    
    public void removeRegion(int regionID) throws Exception;
    
    public List<Region> getAllRegions() throws Exception;
    
    public Region searchRegionById(int regionID) throws Exception;    
}
