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
import sna.repository.entities.Sponsors;

/**
 *
 * @author Jaimon TT
 */
@Stateless
public class SponsorsRepositoryImpl implements SponsorsRepository{
    
    @PersistenceContext(unitName = "SaveNativeAnimals-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addSponsor(Sponsors sponsor) throws Exception {
        entityManager.persist(sponsor);
    }

    @Override
    public void editSponsor(Sponsors sponsor) throws Exception {
        entityManager.merge(sponsor);
    }

    @Override
    public void removeSponsor(int sponsorsID) throws Exception {
        Sponsors sponsor = this.searchSponsorById(sponsorsID);

        if (sponsor != null) {
            entityManager.remove(sponsor);
        }    
    }

    @Override
    public List<Sponsors> getAllSponsor() throws Exception {
        return entityManager.createNamedQuery(Sponsors.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Sponsors searchSponsorById(int sponsorsID) throws Exception {
        Sponsors sponsor = entityManager.find(Sponsors.class, sponsorsID);
        return sponsor;    
    }
    
}
