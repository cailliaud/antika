package jpa.talent;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



@FacesConverter("talentConverter")
public class TalentConverter implements Converter {

    
    private TalentDAO daoTalent =lookupTalentDAOBean();
    
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
      
                return daoTalent.findTalent(value);
            } catch(Exception e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error occured during database request" , e.getMessage()));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Talent) object).getNom());
        }
        else {
            return null;
        }
    }   
    
     private TalentDAO lookupTalentDAOBean() {
        try {
            Context c = new InitialContext();
            return (TalentDAO) c.lookup("java:global/Antika/TalentDAO!jpa.talent.TalentDAO");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}