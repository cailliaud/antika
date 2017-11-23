package views;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import jpa.dieu.Dieu;
import jpa.dieu.DieuDAO;
import jpa.race.Race;
import jpa.race.RaceDAO;
import jpa.talent.Categorie;
import jpa.talent.CategorieDAO;
import jpa.talent.Talent;
import jpa.talent.TalentDAO;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "treeBasicView")
@ViewScoped
public class BasicView implements Serializable {

    @EJB
    private DieuDAO daoDieu;

    @EJB
    private RaceDAO daoRace;

    @EJB
    private CategorieDAO daoCat;
    @EJB
    private TalentDAO daoTalent;
    
    private TreeNode root;

    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("Antika", null);
        DefaultTreeNode dieuNode;
        List<Dieu> listDieux = daoDieu.findAll();
        TreeNode nodeDieu = new DefaultTreeNode("Dieux", root);

        for (Dieu dieu : listDieux) {
            dieuNode = new DefaultTreeNode(dieu.getNom());
            TreeNode nodePouvoir = new DefaultTreeNode("Pouvoirs", dieuNode);
            nodePouvoir.getChildren().add(new DefaultTreeNode(dieu.getPouvoirPrincipal().getNom()));
            nodePouvoir.getChildren().add(new DefaultTreeNode(dieu.getPouvoirSecondaire().getNom()));
            TreeNode nodeRaceOfDieu = new DefaultTreeNode("Races Accessibles", dieuNode);
            for (Race r : dieu.getRaceCollection()) {
                nodeRaceOfDieu.getChildren().add(new DefaultTreeNode(r.getNom()));
            }
            nodeDieu.getChildren().add(dieuNode);
        }

        TreeNode nodeRace = new DefaultTreeNode("Races", root);

        List<Race> listRaces = daoRace.findAll();
        for (Race r : listRaces) {
            nodeRace.getChildren().add(new DefaultTreeNode(r.getNom()));
        }

        TreeNode nodeTalent = new DefaultTreeNode("Talents", root);
        DefaultTreeNode catNode;
        List<Categorie> listCategorie = daoCat.findAll();
        List<Talent> listTalent;
        for (Categorie cat : listCategorie) {
            catNode = new DefaultTreeNode(cat.getNom(), nodeTalent);
            listTalent = daoTalent.selectTalentFromCat(cat.getNom());
            for (Talent talent : listTalent) {
                catNode.getChildren().add(new DefaultTreeNode(talent.getNom()));
            }
        }

    }

    public TreeNode getRoot() {
        return root;
    }
}
