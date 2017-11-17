/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.dieu;

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
public class DieuDAO {
    
    public DieuDAO(){
        
    }
    
    @PersistenceContext(unitName="AntikaPU")
    private EntityManager em;
    
    public List<Dieu> findAll(){
        Query q = em.createNamedQuery("Dieu.findAll");
        return q.getResultList();
    }
}
