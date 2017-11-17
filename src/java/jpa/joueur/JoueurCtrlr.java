/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.joueur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author caill
 */
@ManagedBean
@SessionScoped
public class JoueurCtrlr {
    
    private Joueur joueur;
    
    public JoueurCtrlr(){
        joueur = new Joueur();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    
    
    
}
