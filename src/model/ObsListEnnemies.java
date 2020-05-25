package model;

import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
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
                for (int i = 0; i < change.getAddedSubList().size(); i++) {
                    ViewEnnemi.afficherMob(this.pane, change.getAddedSubList().get(i));
                        for(int j=0; j<this.pane.getChildren().size();j++){
                            if (change.getAddedSubList().get(i).getId().equals(this.pane.getChildren().get(j).getId())){
                                this.pane.getChildren().get(j).translateXProperty().bind(change.getAddedSubList().get(i).getX());
                                this.pane.getChildren().get(j).translateYProperty().bind(change.getAddedSubList().get(i).getY());
                                Label pv = new Label();
                                pv.setId(change.getAddedSubList().get(i).getId());
                                pv.textProperty().bind(change.getAddedSubList().get(i).getPV().asString());
                                pv.translateXProperty().bind(change.getAddedSubList().get(i).getX().subtract(0));
                                pv.translateYProperty().bind(change.getAddedSubList().get(i).getY().subtract(15));
                                this.pane.getChildren().add(pv);
                                break;
                            }
                        }
                }
            }


            else if(change.wasRemoved()){
                for(int i=0; i<this.pane.getChildren().size(); i++){
                    if(this.pane.getChildren().get(i).getId().equals(change.getRemoved().get(change.getFrom()).getId())){
                        this.pane.getChildren().remove(i);
                        this.pane.getChildren().remove(i);
                    }
                }
           }
        }
    }
}
