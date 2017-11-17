/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author caill
 */
@Named(value = "mainControler")
@SessionScoped
@ManagedBean
public class MainControler {

    private String lastPage;

    /**
     * Creates a new instance of MainControler
     */
    public MainControler() {
        super();
    }

    @PostConstruct
    public void init() {
        lastPage = "index";
    }

    public String goToIndex(String currentPage) {
        lastPage = currentPage;
        return "index";
    }

    public String goToCreatePerso(String currentPage) {
        lastPage = currentPage;
        return "createPerso";
    }

    public String goToCreateTalent(String currentPage) {
        lastPage = currentPage;
        return "selectTalent";
    }
    
    public String goToSelectDieu(String currentPage){
        lastPage = currentPage;
        return "selectDieu";
    }

    public String goLastPage(String currentPage) {
        String page = lastPage;
        lastPage = currentPage;
        return page;

    }

    public String goToSelectRace(String currentPage) {
        lastPage = currentPage;
        return "selectRace";
    }
}
