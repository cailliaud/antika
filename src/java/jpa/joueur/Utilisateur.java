/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.joueur;

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
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_UTI")
    private Integer idUti;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUti")
    private Collection<Joueur> joueurCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer idUti) {
        this.idUti = idUti;
    }

    public Utilisateur(Integer idUti, String login, String password) {
        this.idUti = idUti;
        this.login = login;
        this.password = password;
    }

    public Integer getIdUti() {
        return idUti;
    }

    public void setIdUti(Integer idUti) {
        this.idUti = idUti;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        hash += (idUti != null ? idUti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUti == null && other.idUti != null) || (this.idUti != null && !this.idUti.equals(other.idUti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.joueur.Utilisateur[ idUti=" + idUti + " ]";
    }
    
}
