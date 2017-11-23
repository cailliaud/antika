/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.joueur;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.SlideEndEvent;

/**
 *
 * @author caill
 */
@ManagedBean
@SessionScoped
public class JoueurCtrlr {

    private Joueur joueur;

    public JoueurCtrlr() {
        joueur = new Joueur();
    }

    public void resetJoueur() {
        joueur = new Joueur();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String checkSlider() {
        if(joueur.getAge()<60 && joueur.getAge()>14){
            return "selectDieu";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "l'âge dois être compris entre 14 et 60 ans pour participer à l'aventure"));
            return "";
        }
    }
    
    public int convertTaille(String S){
        return Integer.parseInt(S.replace('m', ','));
    }
}
