/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

    public String goToSelectDieu() {
        return "selectDieu";
    }

    public String goToSelectRace() {
        return "selectRace";
    }

    public String goToRecap() {
        return "recap";
    }

    public String goStats(){
        addMessageInfo("Les stats du Mont Olympe", "Les Dieux adorent savoir qui parmis eux à engendrer le plus d'enfants !");
        return "stats";
    }
    
    public String goInfos(){
        addMessageInfo("Le Tartare", "Tu t'es enfoncé dans les méandres du Tartare. Attention de ne pas y croiser un dévleoppeur fou !");
        return "infos";
    }
    
    public String goToMapAntika(){
        addMessageInfo("Exploration de l'Univers","Bon choix ! Explorons ensemble Antika avant de créer ton personnage.");
        return "antikaMap";
    }
    
    public String goToAdminMenu(){
        return "menuAdmin";
    }
    public void goToUnemplementedPage() {
        addMessageError("Page en Travaux", "Patience jeune aventurier ! Héphaïstos travaille actuellement dessus.");
    }

    public String goToListJoueurView() {
        addMessageWarn("Le conseil de Zeus", "Tuer les héros te détendra mais après ça sera à toi de sauver les gens ! Penses y !");
        return "listJoueurs";
    }

    public void addMessageError(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addMessageWarn(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addMessageInfo(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
