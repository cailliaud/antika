/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.talent;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import jpa.joueur.Joueur;

/**
 *
 * @author caill
 */
@Entity
@Table(name = "est_capable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstCapable.findAll", query = "SELECT e FROM EstCapable e")})
public class EstCapable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstCapablePK estCapablePK;
    @Column(name = "POINTS")
    private Integer points;
    @JoinColumn(name = "ID_JOUEUR", referencedColumnName = "ID_JOUEUR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Joueur joueur;
    @JoinColumn(name = "ID_TALENT", referencedColumnName = "ID_TALENT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Talent talent;

    public EstCapable() {
    }

    public EstCapable(EstCapablePK estCapablePK) {
        this.estCapablePK = estCapablePK;
    }

    public EstCapable(int idTalent, int idJoueur) {
        this.estCapablePK = new EstCapablePK(idTalent, idJoueur);
    }

    public EstCapablePK getEstCapablePK() {
        return estCapablePK;
    }

    public void setEstCapablePK(EstCapablePK estCapablePK) {
        this.estCapablePK = estCapablePK;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estCapablePK != null ? estCapablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstCapable)) {
            return false;
        }
        EstCapable other = (EstCapable) object;
        if ((this.estCapablePK == null && other.estCapablePK != null) || (this.estCapablePK != null && !this.estCapablePK.equals(other.estCapablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.talent.EstCapable[ estCapablePK=" + estCapablePK + " ]";
    }
    
}
