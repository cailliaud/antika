/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.talent;

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
public class CategorieDAO {
    public CategorieDAO(){
        
    }
    @PersistenceContext(unitName = "AntikaPU")
    private EntityManager em;
    
     
    public List<Categorie> findAll(){
        Query q = em.createNamedQuery("Categorie.findAll");
        return q.getResultList();
    }
    
}
