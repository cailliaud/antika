/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.joueur;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import jpa.dieu.Dieu;
import jpa.race.Race;
import jpa.talent.Talent;
import jpa.utilisateur.Utilisateur;
import jpa.utilisateur.UtilisateurDAO;

/**
 *
 * @author caill
 */
@ManagedBean
@SessionScoped
public class JoueurCtrlr {

    private Joueur joueur;
    @Size(min=2,max=14 , message="Ton nom est soit trop grand soit trop petit pour être un héros (2 à 14 caractères)")
    private String name;
    @Min(value=40,message = "Oups, tu es trop léger pour partir à l'aventure !") @Max(value= 250,message = "Légalement, on peut pas te laisser partir, tu es trop lourd !")
    private int poids;
    @Min(value = 110,message = "Pas de nains chez les Grecques") @Max(value=250,message = "Tu passes pas les portes, ça peut être chiant !")
    private int taille;
    
    private String sexe;
    
    private Dieu dieu;
    private Race race;
    private List<Talent> listTalents;
    
    @Min(value=14,message = "Mourir à moins de 14 ans c'est moche !") @Max(value=60,message = "Pas d'aventures pour les retraités !")
    private int age;
        

    @EJB
    private JoueurDAO daoJoueur;
    
    @EJB
    private UtilisateurDAO daoUtil;
    
    private Utilisateur utilisateurSelected;
    
    public JoueurCtrlr() {
        joueur = new Joueur();
        age =14;
        poids = 40;
        taille = 160;
        sexe = "Homme";
        name ="Arkantos";
        
    }
    
    @PostConstruct
    public void init(){
        joueur.setAge(14);
        joueur.setSexe("Homme");
    }

    public void resetJoueur() {
        this.joueur = new Joueur();
        age =14;
        poids = 40;
        taille = 160;
        sexe = "Homme";
        name ="Arkantos";
    }
    

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.joueur.setNom(name);
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
        this.joueur.setPoids(poids);
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        this.joueur.setTaille(taille);
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
        this.joueur.setSexe(sexe);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.joueur.setAge(age);
    }

    public Dieu getDieu() {
        return dieu;
    }

    public void setDieu(Dieu dieu) {
        this.dieu = dieu;
        this.joueur.setIdDieu(dieu);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("dieu", this.joueur.getIdDieu());
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
        this.joueur.setIdRace(race);
    }

    public List<Talent> getListTalents() {
        return listTalents;
    }

    public void setListTalents(List<Talent> listTalents) {
        this.listTalents = listTalents;
    }
    
    
    
    public void displayJoueur(){
        String nomDieu =joueur.getIdDieu()!=null ? joueur.getIdDieu().getNom() : "Dieu non sélectionné";

        System.out.println(joueur.getNom()+" ,\n"+joueur.getAge()
                +" ,"+joueur.getPoids()+" Kg, \n"+joueur.getTaille()
                +" m,"+joueur.getSexe()+",Dieu ="+ nomDieu);
    }
    
    
    
    public String saveJoueur(){
        this.joueur.setIdUti( daoUtil.findUser("mj", "antika"));
        daoJoueur.addJoueur(this.joueur);
        return "index";
    }

}
