/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.race;

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
import jpa.joueur.Joueur;

/**
 *
 * @author caill
 */
@Entity
@Table(name = "race")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Race.findAll", query = "SELECT r FROM Race r")
    , @NamedQuery(name = "Race.findByIdRace", query = "SELECT r FROM Race r WHERE r.idRace = :idRace")
    , @NamedQuery(name = "Race.findByNom", query = "SELECT r FROM Race r WHERE r.nom = :nom")
    , @NamedQuery(name = "Race.findByUrlImg", query = "SELECT r FROM Race r WHERE r.urlImg = :urlImg")
    , @NamedQuery(name = "Race.findByInformation", query = "SELECT r FROM Race r WHERE r.information = :information")})
public class Race implements Serializable {

    @OneToMany(mappedBy = "idRace")
    private Collection<Joueur> joueurCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RACE")
    private Integer idRace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 50)
    @Column(name = "URL_IMG")
    private String urlImg;
    @Size(max = 360)
    @Column(name = "Information")
    private String information;

    public Race() {
    }

    public Race(Integer idRace) {
        this.idRace = idRace;
    }

    public Race(Integer idRace, String nom) {
        this.idRace = idRace;
        this.nom = nom;
    }

    public Integer getIdRace() {
        return idRace;
    }

    public void setIdRace(Integer idRace) {
        this.idRace = idRace;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRace != null ? idRace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Race)) {
            return false;
        }
        Race other = (Race) object;
        if ((this.idRace == null && other.idRace != null) || (this.idRace != null && !this.idRace.equals(other.idRace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.race.Race[ idRace=" + idRace + " ]";
    }

    @XmlTransient
    public Collection<Joueur> getJoueurCollection() {
        return joueurCollection;
    }

    public void setJoueurCollection(Collection<Joueur> joueurCollection) {
        this.joueurCollection = joueurCollection;
    }
    
}
