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
import sna.repository.RegionRepository;
import sna.repository.entities.Region;
import sna.repository.entities.Roles;

/**
 *
 * @author Jaimon TT
 */
@ManagedBean(name = "regionManagedBean")
@SessionScoped
public class RegionManagedBean implements Serializable {
     @EJB
    RegionRepository regionRepository;


    public RegionManagedBean() {
    }
    
    public boolean isRquiredEntitiesNotMissing(Region region){
        if(region.getRegionDescription() == null || region.getRegionDescription() == ""|| region.getRegionName() == null
                || region.getRegionName() == ""){
            return false;
        }
        return true;
    }
    
    public String addRegion(sna.controller.entities.Region localVariable,boolean isAdmin){
          Region region = convertRegionToEntity(localVariable);
          return addMainRegion(region,isAdmin);
    }
    
    public String addMainRegion(Region region,boolean isAdmin){
         try {
                if(isRquiredEntitiesNotMissing(region)){
                    regionRepository.addRegion(region);
                }
               if(isAdmin){
                   return "/admin/view/regions.xhtml?faces-redirect=true";
               }
               return "/public/view/regions.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(RegionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    
    
    
    public Region convertRegionToEntity(sna.controller.entities.Region localVariable){
        Region region = new Region();
        region.setRegionDescription(localVariable.getRegionDescription());
        region.setRegionID(localVariable.getRegionID());
        region.setRegionName(localVariable.getRegionName());
        return region;
    }
    
    public String redirectToRegionsViewPage(int id,boolean isAdmin){
        if(isAdmin){
            return "/admin/view/viewRegion.xhtml?faces-redirect=true&regionID=" + id;
        }
        return "/public/view/viewRegion.xhtml?faces-redirect=true&regionID=" + id;
    }
     
    public String editRegion(Region region,boolean isAdmin)
    {
        try {
            if(isRquiredEntitiesNotMissing(region)){
                    regionRepository.editRegion(region);
                }
            return redirectToRegionsViewPage(region.getRegionID(),isAdmin);
        } catch (Exception ex) {
            Logger.getLogger(RegionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String removeRegion(int id){
        try {
            regionRepository.removeRegion(id);
            return "/admin/view/regions.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(RegionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public List<Region> getAllRegions() {
        try {
            return regionRepository.getAllRegions();
        } catch (Exception ex) {
            Logger.getLogger(RegionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Region searchRegionById(int id)
    {
        try {
            return regionRepository.searchRegionById(id);
        } catch (Exception ex) {
            Logger.getLogger(RegionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
