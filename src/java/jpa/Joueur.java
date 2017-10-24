/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author caill
 */
@Entity
@Table(name = "joueur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Joueur.findAll", query = "SELECT j FROM Joueur j")
    , @NamedQuery(name = "Joueur.findByIdJoueur", query = "SELECT j FROM Joueur j WHERE j.idJoueur = :idJoueur")
    , @NamedQuery(name = "Joueur.findByNom", query = "SELECT j FROM Joueur j WHERE j.nom = :nom")
    , @NamedQuery(name = "Joueur.findByTaille", query = "SELECT j FROM Joueur j WHERE j.taille = :taille")
    , @NamedQuery(name = "Joueur.findByPoids", query = "SELECT j FROM Joueur j WHERE j.poids = :poids")
    , @NamedQuery(name = "Joueur.findByAge", query = "SELECT j FROM Joueur j WHERE j.age = :age")})
public class Joueur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_JOUEUR")
    private Integer idJoueur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAILLE")
    private int taille;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POIDS")
    private int poids;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGE")
    private int age;
    @Lob
    @Size(max = 65535)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "ID_DIEU", referencedColumnName = "ID_DIEU")
    @ManyToOne
    private Dieu idDieu;
    @JoinColumn(name = "ID_RACE", referencedColumnName = "ID_RACE")
    @ManyToOne
    private Race idRace;
    @JoinColumn(name = "ID_METIER", referencedColumnName = "ID_METIER")
    @ManyToOne
    private Metier idMetier;

    public Joueur() {
    }

    public Joueur(Integer idJoueur) {
        this.idJoueur = idJoueur;
    }

    public Joueur(Integer idJoueur, String nom, int taille, int poids, int age) {
        this.idJoueur = idJoueur;
        this.nom = nom;
        this.taille = taille;
        this.poids = poids;
        this.age = age;
    }

    public Integer getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(Integer idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dieu getIdDieu() {
        return idDieu;
    }

    public void setIdDieu(Dieu idDieu) {
        this.idDieu = idDieu;
    }

    public Race getIdRace() {
        return idRace;
    }

    public void setIdRace(Race idRace) {
        this.idRace = idRace;
    }

    public Metier getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(Metier idMetier) {
        this.idMetier = idMetier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJoueur != null ? idJoueur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joueur)) {
            return false;
        }
        Joueur other = (Joueur) object;
        if ((this.idJoueur == null && other.idJoueur != null) || (this.idJoueur != null && !this.idJoueur.equals(other.idJoueur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Joueur[ idJoueur=" + idJoueur + " ]";
    }
    
}
