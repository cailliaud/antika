/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.dieu;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author caill
 */
@FacesConverter("dieuConverter")
public class DieuConverter implements Converter {

    DieuDAO dao = lookupDieuDAOBean();
    
    
    public DieuConverter(){
        
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {   
            return dao.findDieu(value);
        } else {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        return ((Dieu) object).getNom();
    }

    private DieuDAO lookupDieuDAOBean() {
        try {
            Context c = new InitialContext();
            return (DieuDAO) c.lookup("java:global/Antika/DieuDAO!jpa.dieu.DieuDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


}
