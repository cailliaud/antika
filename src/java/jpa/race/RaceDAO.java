/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.race;

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
public class RaceDAO {

    public RaceDAO() {
    }
    
    @PersistenceContext(unitName = "AntikaPU")
    private EntityManager em;
    
    public List<Race> findAll(){
        Query q = em.createNamedQuery("Race.findAll");
        return q.getResultList();
    }
    
}
