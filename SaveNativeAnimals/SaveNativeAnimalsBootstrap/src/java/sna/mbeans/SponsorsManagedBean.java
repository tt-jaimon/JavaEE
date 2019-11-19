/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sna.mbeans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sna.repository.SponsorsRepository;
import sna.repository.entities.Sponsors;

/**
 *
 * @author Jaimon TT
 */
@ManagedBean(name = "sponsorsManagedBean")
@SessionScoped
public class SponsorsManagedBean  implements Serializable{
    
    @EJB
    SponsorsRepository sponsorRepository;


    public SponsorsManagedBean() {
    }
    
    public boolean isRquiredEntitiesNotMissing(Sponsors sponsor){
        if(sponsor.getSponsorDescription()== null ||sponsor.getSponsorName() == null|| sponsor.getSponsorName()== ""
                || sponsor.getSponsorDescription() == ""){
            return false;
        }
        return true;
    }
        
    public String addMainSponsor(Sponsors sponsor,boolean isAdmin){
         try {
                if(isRquiredEntitiesNotMissing(sponsor)){
                   sponsorRepository.addSponsor(sponsor);
               }
                if(isAdmin){
                    return "/admin/view/sponsors.xhtml?faces-redirect=true";
                }
               return "/public/view/sponsors.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(SponsorsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    
    public String addSponsor(sna.controller.entities.Sponsors localSponsor,boolean isAdmin){
          Sponsors sponsor = convertSponsorToEntity(localSponsor);
          return addMainSponsor(sponsor,isAdmin);
    }
    
     public Sponsors convertSponsorToEntity(sna.controller.entities.Sponsors localsponsor){
        Sponsors sponsor = new Sponsors();
        sponsor.setEvents(localsponsor.getEvents());
        sponsor.setSponsorDescription(localsponsor.getSponsorDescription());
        sponsor.setSponsorID(localsponsor.getSponsorID());
        sponsor.setSponsorName(localsponsor.getSponsorName());
        return sponsor;
    }
     
    public String redirectToSponsorsViewPage(int id,boolean isAdmin){
        if(isAdmin){
            return "/admin/view/viewSponsor.xhtml?faces-redirect=true&sponsorID=" + id;
        }
        return "/public/view/viewSponsor.xhtml?faces-redirect=true&sponsorID=" + id;
    }
     
    public String editSponsor(Sponsors sponsor,boolean isAdmin)
    {
        try {
            if(isRquiredEntitiesNotMissing(sponsor)){
                sponsorRepository.editSponsor(sponsor);
            }
            return redirectToSponsorsViewPage(sponsor.getSponsorID(), isAdmin);
        } catch (Exception ex) {
            Logger.getLogger(SponsorsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String removeSponsor(int id){
        try {
            sponsorRepository.removeSponsor(id);
            return "/admin/view/sponsors.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(SponsorsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public List<Sponsors> getAllSponsors() {
        try {
            return sponsorRepository.getAllSponsor();
        } catch (Exception ex) {
            Logger.getLogger(SponsorsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Sponsors searchSponsorById(int id)
    {
        try {
            return sponsorRepository.searchSponsorById(id);
        } catch (Exception ex) {
            Logger.getLogger(SponsorsManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
