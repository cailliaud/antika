/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.dieu;

import jpa.dieu.Dieu;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "pouvoir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pouvoir.findAll", query = "SELECT p FROM Pouvoir p")
    , @NamedQuery(name = "Pouvoir.findByIdPouvoir", query = "SELECT p FROM Pouvoir p WHERE p.idPouvoir = :idPouvoir")
    , @NamedQuery(name = "Pouvoir.findByNom", query = "SELECT p FROM Pouvoir p WHERE p.nom = :nom")})
public class Pouvoir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_POUVOIR")
    private Integer idPouvoir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NOM")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pouvoirPrincipal")
    private Collection<Dieu> dieuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pouvoirSecondaire")
    private Collection<Dieu> dieuCollection1;

    public Pouvoir() {
    }

    public Pouvoir(Integer idPouvoir) {
        this.idPouvoir = idPouvoir;
    }

    public Pouvoir(Integer idPouvoir, String nom) {
        this.idPouvoir = idPouvoir;
        this.nom = nom;
    }

    public Integer getIdPouvoir() {
        return idPouvoir;
    }

    public void setIdPouvoir(Integer idPouvoir) {
        this.idPouvoir = idPouvoir;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public Collection<Dieu> getDieuCollection() {
        return dieuCollection;
    }

    public void setDieuCollection(Collection<Dieu> dieuCollection) {
        this.dieuCollection = dieuCollection;
    }

    @XmlTransient
    public Collection<Dieu> getDieuCollection1() {
        return dieuCollection1;
    }

    public void setDieuCollection1(Collection<Dieu> dieuCollection1) {
        this.dieuCollection1 = dieuCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPouvoir != null ? idPouvoir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pouvoir)) {
            return false;
        }
        Pouvoir other = (Pouvoir) object;
        if ((this.idPouvoir == null && other.idPouvoir != null) || (this.idPouvoir != null && !this.idPouvoir.equals(other.idPouvoir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.perso.Pouvoir[ idPouvoir=" + idPouvoir + " ]";
    }
    
}
