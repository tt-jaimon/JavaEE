/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.repository;
import java.util.List;
import javax.ejb.Remote;
import sna.repository.entities.Events;

/**
 *
 * @author Jaimon TT
 */
@Remote
public interface EventsRepository {
    
    public void addEvent(Events event) throws Exception;
    
    public void editEvent(Events event) throws Exception;
    
    public void removeEvent(int eventID) throws Exception;
    
    public List<Events> getAllEvents() throws Exception;
    
    public Events searchEventById(int eventID) throws Exception;
    
}
