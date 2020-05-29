package model.ListeObservable;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Tir;

public class ObsListTirs  implements ListChangeListener<Tir> {

    private Pane pane;

    public ObsListTirs(Pane p){
        this.pane =p;
    }

    @Override
    public void onChanged(Change<? extends Tir> change) {
        while(change.next()) {
            if (change.wasAdded()) {
                for(int i=0; i<change.getAddedSubList().size(); i++){
                    Circle r = new Circle(2);
                    r.setFill(Color.RED);
                    r.translateXProperty().bind(change.getAddedSubList().get(i).getX());
                    r.translateYProperty().bind(change.getAddedSubList().get(i).getY());
                    r.setId(change.getAddedSubList().get(i).getId());
                    this.pane.getChildren().add(r);
                }
            }

            else if(change.wasRemoved()){
                for(Node c : this.pane.getChildren()){
                    if(c.getId().equals(change.getRemoved().get(0).getId())){
                        this.pane.getChildren().remove(c);
                        break;
                    }
                }
            }
        }
    }
}
