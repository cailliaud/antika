/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.joueur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
     
     
    
    
}
