/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.talent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author moi
 */
@ViewScoped
@ManagedBean
public class TalentCtrlr implements Serializable {

    @EJB
    private TalentDAO dao;

    private DualListModel<Talent> dmlTalent;

    public TalentCtrlr() {
    }

    @PostConstruct
    public void init() {
        List<Talent> talentsSource = new ArrayList<>();
        List<Talent> talentsTarget = new ArrayList<>();

        talentsSource = dao.findAll();
        dmlTalent = new DualListModel<>(talentsSource, talentsTarget);
        
    }

    public DualListModel<Talent> getDMLtalent() {
        return dmlTalent;
    }

    public void setDMLtalent(DualListModel<Talent> DMLtalent) {
        this.dmlTalent = DMLtalent;
    }

    public List<Talent> getTalent() {
        return dao.findAll();
    }


    
    public void displaySelected(){
        String res="";
        for (Object t : dmlTalent.getTarget()) {
            
            res+=" "+t.toString();
            
        }
        System.out.println(res);
    }
}
