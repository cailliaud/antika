/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import jpa.joueur.Joueur;
import jpa.joueur.JoueurCtrlr;

/**
 *
 * @author caill
 */
@Named(value = "mainControler")
@SessionScoped
@ManagedBean
public class MainControler {



    /**
     * Creates a new instance of MainControler
     */
    public MainControler() {
        super();
    }

    @PostConstruct
    public void init() {
    }

    public String goToIndex() {
        return "index";
    }

    public String goToCreatePerso() {
        return "createPerso";
    }

    public String goToSelectTalent() {

        return "selectTalent";
    }
    
    public String goToSelectDieu(){
        return "selectDieu";
    }


    public String goToSelectRace() {
        return "selectRace";
    }
}
