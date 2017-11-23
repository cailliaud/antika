package views;
 
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.enterprise.inject.Default;
import javax.faces.bean.ManagedBean;
import jpa.dieu.Dieu;
import jpa.dieu.DieuDAO;
import jpa.race.Race;
import jpa.race.RaceDAO;
 
import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;
 
@ManagedBean
public class MindmapView implements Serializable {
    @EJB
    private DieuDAO daoDieu;
    
    @EJB
    private RaceDAO daoRace;
    
    private MindmapNode root;
     
    private MindmapNode selectedNode;
     
    public MindmapView() {
        root = new DefaultMindmapNode("Antika", "Antika", "FFCC00", false);

        MindmapNode dieux = new DefaultMindmapNode("Dieux", "Dieux de l'univers", "6e9ebf", true);
        MindmapNode races = new DefaultMindmapNode("Races", "Races de l'univers", "6e9ebf", true);
        root.addNode(dieux);
        root.addNode(races);
    }
 
    public MindmapNode getRoot() {
        return root;
    }
 
    public MindmapNode getSelectedNode() {
        return selectedNode;
    }
    public void setSelectedNode(MindmapNode selectedNode) {
        this.selectedNode = selectedNode;
    }
 
    public void onNodeSelect(SelectEvent event) {
        MindmapNode node = (MindmapNode) event.getObject();
 
        //populate if not already loaded
        if(node.getChildren().isEmpty()) {
            Object label = node.getLabel();
 
           if(label.equals("Dieux")) {
                List<Dieu> listDieux = daoDieu.findAll();
                for (Dieu d : listDieux) {
    
                    node.addNode( new DefaultMindmapNode(d.getNom(), d.getNom(), "3399ff", true));
                    
                }  
            }else if (label.equals("Races")){
               List<Race> listRaces = daoRace.findAll();
               for (Race r : listRaces ){
                   node.addNode(new DefaultMindmapNode(r.getNom(), r.getNom(), "3399ff", false));
               }
               
           }
        }   
    }
     
    public void onNodeDblselect(SelectEvent event) {
        this.selectedNode = (MindmapNode) event.getObject();        
    }
}