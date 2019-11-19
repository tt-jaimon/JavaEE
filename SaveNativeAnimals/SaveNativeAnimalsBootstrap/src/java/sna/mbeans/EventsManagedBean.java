/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.mbeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sna.repository.EventsRepository;
import sna.repository.entities.Events;
import sna.repository.entities.Region;

/**
 *
 * @author Jaimon TT
 */
@ManagedBean(name = "eventsManagedBean")
@SessionScoped
public class EventsManagedBean implements Serializable {
     @EJB
    EventsRepository eventsRepository;


    public EventsManagedBean() {
    }
    
    public boolean isRquiredEntitiesNotMissing(Events event){
        if(event.getEndingDate() == null || event.getAnimalID()== null || event.getRegionID()== null
                || event.getSponsorID()== null|| event.getStartingDate()== null || event.getEventName() ==null
                || event.getEventName() == "" || event.getEventDescription() == null || event.getEventDescription() ==""){
            return false;
        }
        return true;
    }
    
    public String addMainEvent(Events event,boolean isAdmin){
         try {
                if(isRquiredEntitiesNotMissing(event)){
                    eventsRepository.addEvent(event);
                }
               if(isAdmin){
                   return "/admin/view/events.xhtml?faces-redirect=true";
               }
               return "/public/view/events.xhtml?faces-redirect=true";

        } catch (Exception ex) {
            Logger.getLogger(EventsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    
    public String addEvent(sna.controller.entities.Events localVariable,boolean isAdmin){
          Events event = convertEventToEntity(localVariable);
          return addMainEvent(event,isAdmin);
    }
    
     public Events convertEventToEntity(sna.controller.entities.Events localVariable){
        Events event = new Events();
        event.setAnimalID(localVariable.getAnimalID());
        Date endingDate = new Date(localVariable.getEndingDate().getTime());
        event.setEndingDate(endingDate);
        event.setEventDescription(localVariable.getEventDescription());
        event.setEventID(localVariable.getEventID());
        event.setEventName(localVariable.getEventName());
        event.setRegionID(localVariable.getRegionID());
        event.setSponsorID(localVariable.getSponsorID());
        Date startingDate = new Date(localVariable.getStartingDate().getTime());
        event.setStartingDate(startingDate);
        return event;
    }
     
     public sna.controller.entities.Events convertEventToControllerEntity(Events localVariable){
        sna.controller.entities.Events event = new sna.controller.entities.Events();
        event.setAnimalID(localVariable.getAnimalID());
        java.util.Date endingDate = new java.util.Date(localVariable.getEndingDate().getTime());
        event.setEndingDate(endingDate);
        event.setEventDescription(localVariable.getEventDescription());
        event.setEventID(localVariable.getEventID());
        event.setEventName(localVariable.getEventName());
        event.setRegionID(localVariable.getRegionID());
        event.setSponsorID(localVariable.getSponsorID());
        java.util.Date startingDate = new java.util.Date(localVariable.getStartingDate().getTime());
        event.setStartingDate(startingDate);
        return event;
     }
     
    public String redirectToEventsViewPage(int id,boolean isAdmin){
        if(isAdmin){
            return "/admin/view/viewEvent.xhtml?faces-redirect=true&eventID=" + id;
        }
        return "/public/view/viewEvent.xhtml?faces-redirect=true&eventID=" + id;
    }
    
    public String editEvent(sna.controller.entities.Events localVariable,boolean isAdmin){
          Events event = convertEventToEntity(localVariable);
          return editMainEvent(event,isAdmin);
    }
     
    public String editMainEvent(Events event,boolean isAdmin)
    {
        try {
            if(isRquiredEntitiesNotMissing(event)){
                    eventsRepository.editEvent(event);
                }
            return redirectToEventsViewPage(event.getEventID(),isAdmin);
        } catch (Exception ex) {
            Logger.getLogger(EventsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String removeEvent(int id){
        try {
            eventsRepository.removeEvent(id);
            return "/admin/view/events.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(EventsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public List<Events> getAllEvents() {
        try {
            return eventsRepository.getAllEvents();
        } catch (Exception ex) {
            Logger.getLogger(EventsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Events searchEventById(int id)
    {
        try {
            return eventsRepository.searchEventById(id);
        } catch (Exception ex) {
            Logger.getLogger(EventsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
