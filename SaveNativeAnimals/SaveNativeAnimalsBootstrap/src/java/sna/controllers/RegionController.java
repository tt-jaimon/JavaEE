package sna.controllers;

import java.util.Map;
import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import sna.mbeans.RegionManagedBean;
import sna.repository.entities.Region;

/**
 *
 * @author Jaimon TT
 */
@Named(value = "regionController")
@RequestScoped
public class RegionController{
    @ManagedProperty(value="#{regionManagedBean}") 
    RegionManagedBean regionManagedBean;

    private Integer regionID; 
    private Region region;
    

    public RegionController() {
        Map<String, String> parameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if(parameterMap.get("regionID") == null){
            regionID = null;
            return;   
        }
        regionID = Integer.valueOf(parameterMap.get("regionID"));
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            regionManagedBean = (RegionManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "regionManagedBean");
        region = regionManagedBean.searchRegionById(regionID);
    }

    public Region getRegion() {
        return region;
    }
    
    public Integer getRegionID(){
        return regionID;
    }
    
}
