/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.talent;

import java.util.ArrayList;
import jpa.Talent.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author moi
 */
@Stateless
public class TalentDAO {

    public TalentDAO() {
    }
    
    @PersistenceContext(unitName = "AntikaPU")
    private EntityManager em;
    
    public List<Talent> findAll(){
        Query q = em.createNamedQuery("Talent.findAll");
        return q.getResultList();
    }
    
    public List<Talent> selectTalentFromCat(String categorie){
        List<Talent> allTal = findAll();
        List<Talent> talents = new ArrayList<>();
        for (Talent talent : allTal) {
            if (talent.getIdCat().getNom().equals(categorie)){
                talents.add(talent);
            }
        }
        return talents;
    }
    
    public Talent findByID(String idTalent){
        Query q = em.createNamedQuery("Talent.findByIdTalent").setParameter("idTalent", idTalent);
        return (Talent) q.getSingleResult();
    }
    
    public Talent findTalent(String nom){
        Query q = em.createNamedQuery("Talent.findByNom").setParameter("nom", nom);
        return (Talent) q.getSingleResult();
    }
    
}
