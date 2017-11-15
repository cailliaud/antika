/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author caill
 */
@Named(value = "mainControler")
@Dependent
public class MainControler {

    /**
     * Creates a new instance of MainControler
     */
    public MainControler() {
    }
    
    public String goToCreatePerso(){
        return "createPers";
    }
     public String goToCreateTalent(){
        return "createTalent";
    }
}
