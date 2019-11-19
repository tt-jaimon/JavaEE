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
import sna.repository.entities.Region;

/**
 *
 * @author Jaimon TT
 */
@Stateless
public class RegionRepositoryImpl implements RegionRepository {
    
    @PersistenceContext(unitName = "SaveNativeAnimals-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addRegion(Region region) throws Exception {
        entityManager.persist(region);
    }

    @Override
    public void editRegion(Region region) throws Exception {
        entityManager.merge(region);
    }

    @Override
    public void removeRegion(int regionID) throws Exception {
        Region region = this.searchRegionById(regionID);

        if (region != null) {
            entityManager.remove(region);
        }    
    }

    @Override
    public List<Region> getAllRegions() throws Exception {
        return entityManager.createNamedQuery(Region.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Region searchRegionById(int regionID) throws Exception {
        Region region = entityManager.find(Region.class, regionID);
        return region;    
    }
    
}
