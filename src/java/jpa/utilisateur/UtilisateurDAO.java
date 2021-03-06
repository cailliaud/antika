/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.utilisateur;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author caill
 */
@Stateless
public class UtilisateurDAO {

    @PersistenceContext(unitName = "AntikaPU")
    private EntityManager em;

    public UtilisateurDAO() {

    }

    public List<Utilisateur> findAll() {
        Query q = em.createNamedQuery("Utilisateur.findAll");
        return q.getResultList();
    }
    
    public Utilisateur findUser(String login, String password){
        List<Utilisateur> listUti = findAll();
        for (Utilisateur u : listUti) {
            if (u!=null && u.getLogin().equals(login) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

}
