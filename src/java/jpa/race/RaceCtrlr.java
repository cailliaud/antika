/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.race;

import java.io.Serializable;
import java.time.Clock;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import jpa.dieu.Dieu;
import jpa.dieu.DieuDAO;

/**
 *
 * @author caill
 */
@ViewScoped
@ManagedBean
public class RaceCtrlr implements Serializable{
    
    @EJB
    private RaceDAO daoRace;
    private Dieu dieuSelected;
    private Race raceSelected;

    
    public RaceCtrlr() {
    }
    
    @PostConstruct
    public void init(){
        dieuSelected = (Dieu)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("dieu");
    }
    
    public Dieu getDieuSelected(){
        return this.dieuSelected;
    }
    
    public List<Race> getRaces(){
        
        if (dieuSelected!=null){
             return ((List<Race>) dieuSelected.getRaceCollection());
        }else {
            return daoRace.findAll();
        }
       


    }
    

    
    public Race getRaceSelected() {
        return raceSelected;
    }

    public void setRaceSelected(Race raceSelected) {
        this.raceSelected = raceSelected;
    }
    
    public String getInformation(){
        if (raceSelected==null || raceSelected.equals(null)){
            return "Cliquez sur une race pour obtenir plus ample information";
        }else{
            return raceSelected.getInformation();
        }
    }
    
    public String getValueButtonNext(){
        if (raceSelected==null || raceSelected.equals(null)){
            return "Choisis d'abord une race !";
        }else{
            return "Je serais un "+raceSelected.getNom();
        }
    }
    
    public boolean raceIsSelected(){
        if (raceSelected==null ){
            return false;
        }else{
            return true;
        }
    }
   
    
}
