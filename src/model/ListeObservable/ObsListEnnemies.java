package model.ListeObservable;

import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Ennemies.Ennemis;
import view.ViewEnnemi;

public class ObsListEnnemies implements ListChangeListener<Ennemis> {
    //Liste qui observe comment réagi la liste d'ennemis du modèle

    private Pane pane;
    private ViewEnnemi vE;

    public ObsListEnnemies(Pane p, ViewEnnemi e){
        this.pane =p;
        this.vE = e;
    }

    @Override
    public void onChanged(Change<? extends Ennemis> change) {
        while(change.next()){
            //Si un ennemi est ajouté, on lui crée un sprite qui sera lié à ses coordonnées du modèle dans la vue
            if(change.wasAdded()){
                for (int i = 0; i < change.getAddedSubList().size(); i++) {
                    this.vE.afficherMob(change.getAddedSubList().get(i));
                    for(int j=0; j<this.pane.getChildren().size();j++){
                        if (change.getAddedSubList().get(i).getId().equals(this.pane.getChildren().get(j).getId())){
                            this.pane.getChildren().get(j).translateXProperty().bind(change.getAddedSubList().get(i).getXProperty());
                            this.pane.getChildren().get(j).translateYProperty().bind(change.getAddedSubList().get(i).getYProperty());

                            //On crée un label en même temps qui contiendra les pv de l'ennemis et on lie ses coordonée à celle de l'ennemi pour qu'il le suive
                            Label pv = new Label();
                            pv.setTextFill(Color.WHITE);
                            pv.setId(change.getAddedSubList().get(i).getId());
                            pv.textProperty().bind(change.getAddedSubList().get(i).getPVProperty().asString());
                            pv.translateXProperty().bind(change.getAddedSubList().get(i).getXProperty().subtract(0));
                            pv.translateYProperty().bind(change.getAddedSubList().get(i).getYProperty().subtract(15));
                            this.pane.getChildren().add(pv);
                            break;
                        }
                    }
                }
            }

            //Si un ennemi est supprimé on cherche dans la liste des ennemis du controller le bon et supprime son label de PV
            else if(change.wasRemoved()) {
                for(int i=0; i<this.pane.getChildren().size(); ++i) {
                    if (this.pane.getChildren().get(i).getId().equals(change.getRemoved().get(0).getId())) {
                        this.pane.getChildren().remove(i);
                        this.pane.getChildren().remove(i);
                    }
                }
            }
        }
    }
}
