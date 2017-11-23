/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.joueur;

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
public class JoueurDAO {
     @PersistenceContext(unitName = "AntikaPU")
    private EntityManager em;
     
     public JoueurDAO(){
         
     }
     
     public void addJoueur(Joueur j){
         em.persist(j);
         em.flush();
     }
     
     public List<Joueur> findAll(){
         Query q = em.createNamedQuery("Joueur.findAll");
         return q.getResultList();
     }
     
     public void killJoueur(Joueur j){
         em.remove(em.merge(j));
         em.flush();
     }
     
     
    
    
}
