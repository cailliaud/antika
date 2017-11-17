/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.dieu;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import jpa.joueur.Joueur;

/**
 *
 * @author caill
 */
@Entity
@Table(name = "dieu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dieu.findAll", query = "SELECT d FROM Dieu d")
    , @NamedQuery(name = "Dieu.findByIdDieu", query = "SELECT d FROM Dieu d WHERE d.idDieu = :idDieu")
    , @NamedQuery(name = "Dieu.findByNom", query = "SELECT d FROM Dieu d WHERE d.nom = :nom")
    , @NamedQuery(name = "Dieu.findByUrlImg", query = "SELECT d FROM Dieu d WHERE d.urlImg = :urlImg")})
public class Dieu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DIEU")
    private Integer idDieu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 50)
    @Column(name = "URL_IMG")
    private String urlImg;
    @OneToMany(mappedBy = "idDieu")
    private Collection<Joueur> joueurCollection;
    @JoinColumn(name = "POUVOIR_PRINCIPAL", referencedColumnName = "ID_POUVOIR")
    @ManyToOne(optional = false)
    private Pouvoir pouvoirPrincipal;
    @JoinColumn(name = "POUVOIR_SECONDAIRE", referencedColumnName = "ID_POUVOIR")
    @ManyToOne(optional = false)
    private Pouvoir pouvoirSecondaire;

    public Dieu() {
    }

    public Dieu(Integer idDieu) {
        this.idDieu = idDieu;
    }

    public Dieu(Integer idDieu, String nom) {
        this.idDieu = idDieu;
        this.nom = nom;
    }

    public Integer getIdDieu() {
        return idDieu;
    }

    public void setIdDieu(Integer idDieu) {
        this.idDieu = idDieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @XmlTransient
    public Collection<Joueur> getJoueurCollection() {
        return joueurCollection;
    }

    public void setJoueurCollection(Collection<Joueur> joueurCollection) {
        this.joueurCollection = joueurCollection;
    }

    public Pouvoir getPouvoirPrincipal() {
        return pouvoirPrincipal;
    }

    public void setPouvoirPrincipal(Pouvoir pouvoirPrincipal) {
        this.pouvoirPrincipal = pouvoirPrincipal;
    }

    public Pouvoir getPouvoirSecondaire() {
        return pouvoirSecondaire;
    }

    public void setPouvoirSecondaire(Pouvoir pouvoirSecondaire) {
        this.pouvoirSecondaire = pouvoirSecondaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDieu != null ? idDieu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dieu)) {
            return false;
        }
        Dieu other = (Dieu) object;
        if ((this.idDieu == null && other.idDieu != null) || (this.idDieu != null && !this.idDieu.equals(other.idDieu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.perso.Dieu[ idDieu=" + idDieu + " ]";
    }
    
}
