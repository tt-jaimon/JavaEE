package sna.controllers;

import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import sna.mbeans.SponsorsManagedBean;
import sna.repository.entities.Sponsors;

/**
 *
 * @author Jaimon TT
 */
@Named(value = "sponsorController")
@RequestScoped
public class SponsorController{
    @ManagedProperty(value="#{sponsorsManagedBean}") 
    SponsorsManagedBean sponsorsManagedBean;

    private int sponsorID; 
    private Sponsors sponsor;
    

    public SponsorController() {
        sponsorID = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("sponsorID"));
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            sponsorsManagedBean = (SponsorsManagedBean) FacesContext.getCurrentInstance().getApplication()
            .getELResolver().getValue(elContext, null, "sponsorsManagedBean");
        sponsor = sponsorsManagedBean.searchSponsorById(sponsorID);
    }

    public Sponsors getSponsor() {
        return sponsor;
    }

}
