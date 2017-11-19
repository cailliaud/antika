/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.dieu;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author caill
 */
@RequestScoped
@ManagedBean
public class DieuCtrlr implements Serializable{
    
    @EJB
    private DieuDAO dao;
    
    private Dieu dieuSelected;

    
    public DieuCtrlr() {
    }
    
    public List<Dieu> getDieux(){
        return dao.findAll();


    }
    
    public Dieu getDieuSelected() {
        return dieuSelected;
    }

    public void setDieuSelected(Dieu dieuSelected) {
        this.dieuSelected = dieuSelected;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("dieu", dieuSelected);
    }
    
    public String getInformation(){
        if (dieuSelected==null || dieuSelected.equals(null)){
            return "Cliquez sur un dieu pour obtenir plus ample information";
        }else{
            return dieuSelected.getNom();
        }
    }
    
    public String getValueButtonNext(){
        if (dieuSelected==null || dieuSelected.equals(null)){
            return "Choisis d'abord un dieu !";
        }else{
            return "Je serais un "+dieuSelected.getNom();
        }
    }
    
    public boolean dieuSelected(){
        if (dieuSelected==null || dieuSelected.equals(null)){
            return false;
        }else{
            return true;
        }
    }
   
    
}
