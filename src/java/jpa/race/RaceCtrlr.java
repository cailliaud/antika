/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.race;

import java.io.Serializable;
import java.time.Clock;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author caill
 */
@RequestScoped
@ManagedBean
public class RaceCtrlr implements Serializable{
    
    @EJB
    private RaceDAO dao;
    
    private Race raceSelected;

    
    public RaceCtrlr() {
    }
    
    public List<Race> getRaces(){
        return dao.findAll();


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
    
    public boolean raceSelected(){
        if (raceSelected==null || raceSelected.equals(null)){
            return false;
        }else{
            return true;
        }
    }
   
    
}
