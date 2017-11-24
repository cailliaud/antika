package jpa.joueur;
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
@ViewScoped
@ManagedBean
public class DialogView implements Serializable{
 
    @EJB
    private JoueurDAO jdao;
    private Joueur joueurSelected;
    private List<Joueur> listJoueur;


    @PostConstruct
    public void init(){
        this.listJoueur = jdao.findAll();
    }

    public void setListJoueur(List<Joueur> listJoueur) {
        this.listJoueur = jdao.findAll();
    }
    
    public List<Joueur> getListJoueur(){
        return this.listJoueur;
    }
    
    
    
    public void killJoueur(Joueur j) {
        jdao.killJoueur(j);
        this.listJoueur = jdao.findAll();
        addMessage("Vous avez tué un héros", j.getNom()+" n'est désormais plus de notre monde !");
        
        
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Joueur getJoueurSelected() {
        return joueurSelected;
    }

    public void setJoueurSelected(Joueur joueurSelected) {
        this.joueurSelected = joueurSelected;
    }
    
    
}