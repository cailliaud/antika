/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.talent;

import jpa.Talent.*;
import java.io.Serializable;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author caill
 */
@RequestScoped
@ManagedBean
public class TalentCtrlr implements Serializable{
    
    @EJB
    private TalentDAO dao;
    
    private Talent talentSelected;

    private DualListModel<Talent> DMLtalent;
    
    
    
    public TalentCtrlr() {
    }
    
    @PostConstruct
    public void init(){
        List<Talent> talentsSource = new ArrayList<Talent>();
        List<Talent> talentsTarget = new ArrayList<Talent>();

        talentsSource=dao.findAll();
        
        DMLtalent = new DualListModel<Talent>(talentsSource,talentsTarget);
    }

    public DualListModel<Talent> getDMLtalent() {
        return DMLtalent;
    }

    public void setDMLtalent(DualListModel<Talent> DMLtalent) {
        this.DMLtalent = DMLtalent;
    }

    
    
    public List<Talent> getTalent(){
        return dao.findAll();
    }
    
    public Talent getTalentSelected() {
        return talentSelected;
    }

    public void setTalentSelected(Talent talentSelected) {
        this.talentSelected = talentSelected;
    }
    
    
    
     public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Talent) item).getNom()).append("<br />");
        }
         
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
 
     
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 
    
}
