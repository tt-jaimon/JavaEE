package sna.controllers;

import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import sna.mbeans.EventsManagedBean;
import sna.controller.entities.Events;

/**
 *
 * @author Jaimon TT
 */
@Named(value = "eventController")
@RequestScoped
public class EventController{
    @ManagedProperty(value="#{eventsManagedBean}") 
    EventsManagedBean eventsManagedBean;

    private int eventID; 
    private Events event;
    

    public EventController() {
        eventID = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("eventID"));
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            eventsManagedBean = (EventsManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "eventsManagedBean");
        event = eventsManagedBean.convertEventToControllerEntity(eventsManagedBean.searchEventById(eventID));
    }

    public Events getEvent() {
        return event;
    }

}
