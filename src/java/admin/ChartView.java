/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import jpa.dieu.Dieu;
import jpa.dieu.DieuDAO;
import jpa.joueur.Joueur;
import jpa.race.Race;
import jpa.race.RaceDAO;
import org.primefaces.event.ItemSelectEvent;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
@ViewScoped
public class ChartView implements Serializable {

    @EJB
    private DieuDAO daoDieu;
    
    @EJB
    private RaceDAO daoRace;
    private BarChartModel barModel;
    private PieChartModel pieModel;

    @PostConstruct
    public void init() {
        createBarModel();
        createPieModel();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public PieChartModel getPieMode1() {
        return pieModel;
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle("Dieux et Déesses joués");
        barModel.setLegendPosition("nw");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Dieux");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nombre de joueurs");
        yAxis.setMin(0);

    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        ChartSeries hommes = getDieuxStatFromSexe("Homme");
        ChartSeries femmes = getDieuxStatFromSexe("Femme");

        model.addSeries(hommes);
        model.addSeries(femmes);

        return model;
    }

    private void createPieModel() {
        pieModel = new PieChartModel();
        for(Race r : daoRace.findAll()){
            pieModel.set(r.getNom(),r.getJoueurCollection().size());
        }
     
        pieModel.setTitle("Le camembert des races jouées");
        pieModel.setLegendPosition("w");
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Statistique Dieu",
                "C'est grave de vouloir cliquer partout !");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private ChartSeries getDieuxStatFromSexe(String sexe) {
        ChartSeries chart = new ChartSeries();
        int counter = 0;
        chart.setLabel(sexe);
        for (Dieu d : daoDieu.findAll()) {
            List<Joueur> jList = (List<Joueur>) d.getJoueurCollection();
            counter = jList.stream().filter((j) -> (j.getSexe().equals(sexe))).map((_item) -> 1).reduce(counter, Integer::sum);
            chart.set(d.getNom(), counter);
            counter = 0;

        }
        return chart;

    }
}
