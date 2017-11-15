/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.talent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author moi
 */
@Entity
@Table(name = "talent")
@NamedQueries({
    @NamedQuery(name = "Talent.findAll", query = "SELECT t FROM Talent t")
    , @NamedQuery(name = "Talent.findByIdTalent", query = "SELECT t FROM Talent t WHERE t.idTalent = :idTalent")
    , @NamedQuery(name = "Talent.findByNom", query = "SELECT t FROM Talent t WHERE t.nom = :nom")})
public class Talent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TALENT")
    private Integer idTalent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOM")
    private String nom;
    @JoinColumn(name = "ID_CAT", referencedColumnName = "ID_CAT")
    @ManyToOne(optional = false)
    private Categorie idCat;

    public Talent() {
    }

    public Talent(Integer idTalent) {
        this.idTalent = idTalent;
    }

    public Talent(Integer idTalent, String nom) {
        this.idTalent = idTalent;
        this.nom = nom;
    }

    public Integer getIdTalent() {
        return idTalent;
    }

    public void setIdTalent(Integer idTalent) {
        this.idTalent = idTalent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getIdCat() {
        return idCat;
    }

    public void setIdCat(Categorie idCat) {
        this.idCat = idCat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTalent != null ? idTalent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talent)) {
            return false;
        }
        Talent other = (Talent) object;
        if ((this.idTalent == null && other.idTalent != null) || (this.idTalent != null && !this.idTalent.equals(other.idTalent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.talent.Talent[ idTalent=" + idTalent + " ]";
    }
    
}
