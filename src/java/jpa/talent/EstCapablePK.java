/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.talent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author caill
 */
@Embeddable
public class EstCapablePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_TALENT")
    private int idTalent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_JOUEUR")
    private int idJoueur;

    public EstCapablePK() {
    }

    public EstCapablePK(int idTalent, int idJoueur) {
        this.idTalent = idTalent;
        this.idJoueur = idJoueur;
    }

    public int getIdTalent() {
        return idTalent;
    }

    public void setIdTalent(int idTalent) {
        this.idTalent = idTalent;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTalent;
        hash += (int) idJoueur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstCapablePK)) {
            return false;
        }
        EstCapablePK other = (EstCapablePK) object;
        if (this.idTalent != other.idTalent) {
            return false;
        }
        if (this.idJoueur != other.idJoueur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.talent.EstCapablePK[ idTalent=" + idTalent + ", idJoueur=" + idJoueur + " ]";
    }
    
}
