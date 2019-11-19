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
import sna.repository.entities.Events;

/**
 *
 * @author Jaimon TT
 */
@Stateless
public class EventsRepositoryImpl implements EventsRepository{
    
    @PersistenceContext(unitName = "SaveNativeAnimals-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addEvent(Events event) throws Exception {
        entityManager.persist(event);
    }

    @Override
    public void editEvent(Events event) throws Exception {
        entityManager.merge(event);
    }

    @Override
    public void removeEvent(int eventID) throws Exception {
        Events event = this.searchEventById(eventID);

        if (event != null) {
            entityManager.remove(event);
        }    
    }

    @Override
    public List<Events> getAllEvents() throws Exception {
        return entityManager.createNamedQuery(Events.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Events searchEventById(int eventID) throws Exception {
        Events event = entityManager.find(Events.class, eventID);
        return event;    
    }
    
}
