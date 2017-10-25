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
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author caill
 */
@SessionScoped
@ManagedBean
public class RaceCtrlr implements Serializable{
    
    @EJB
    private RaceDAO dao;

    public RaceCtrlr() {
    }
    
    public List<Race> getRaces(){
        return dao.findAll();


    }
    
    
}
