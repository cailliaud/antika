/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author caill
 */
@Entity
@Table(name = "metier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metier.findAll", query = "SELECT m FROM Metier m")
    , @NamedQuery(name = "Metier.findByIdMetier", query = "SELECT m FROM Metier m WHERE m.idMetier = :idMetier")
    , @NamedQuery(name = "Metier.findByNom", query = "SELECT m FROM Metier m WHERE m.nom = :nom")})
public class Metier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_METIER")
    private Integer idMetier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM")
    private String nom;
    @OneToMany(mappedBy = "idMetier")
    private Collection<Joueur> joueurCollection;

    public Metier() {
    }

    public Metier(Integer idMetier) {
        this.idMetier = idMetier;
    }

    public Metier(Integer idMetier, String nom) {
        this.idMetier = idMetier;
        this.nom = nom;
    }

    public Integer getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(Integer idMetier) {
        this.idMetier = idMetier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Joueur> getJoueurCollection() {
        return joueurCollection;
    }

    public void setJoueurCollection(Collection<Joueur> joueurCollection) {
        this.joueurCollection = joueurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetier != null ? idMetier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metier)) {
            return false;
        }
        Metier other = (Metier) object;
        if ((this.idMetier == null && other.idMetier != null) || (this.idMetier != null && !this.idMetier.equals(other.idMetier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Metier[ idMetier=" + idMetier + " ]";
    }
    
}
