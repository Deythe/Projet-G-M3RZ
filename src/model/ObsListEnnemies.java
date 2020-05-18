package model;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import view.ViewEnnemi;
import view.ViewTourelle;

public class ObsListEnnemies implements ListChangeListener<Ennemies> {

    private Pane pane;

    public ObsListEnnemies(Pane p){
        this.pane =p;
    }

    @Override
    public void onChanged(Change<? extends Ennemies> change) {
        while(change.next()){
            if(change.wasAdded()){
                for (int i = 0; i < change.getAddedSubList().size(); ++i) {
                    ViewEnnemi.afficherMob(this.pane, change.getAddedSubList().get(i));
                    this.pane.getChildren().get(i).translateXProperty().bind(change.getAddedSubList().get(i).getX());
                    this.pane.getChildren().get(i).translateYProperty().bind(change.getAddedSubList().get(i).getY());
                }
            }
        }
    }
}
