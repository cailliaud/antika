/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import jpa.dieu.Dieu;
import jpa.dieu.DieuDAO;

/**
 *
 * @author caill
 */
@ManagedBean
@SessionScoped
public class GestionDieux implements Serializable {

    @EJB
    private DieuDAO daoDieu;
    private Dieu dieuSelected;

    public GestionDieux() {

    }

    public Dieu getDieuSelected() {
        return dieuSelected;
    }

    public void setDieuSelected(Dieu dieuSelected) {
        this.dieuSelected = dieuSelected;
    }

    public List<Dieu> getDieux() {
        return daoDieu.findAll();
    }

    public void modifyDieu() {
        daoDieu.update(this.dieuSelected);
        addMessage("Dieu modifié", "La modification a été effectué !");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
