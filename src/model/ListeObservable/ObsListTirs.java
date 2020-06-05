package model.ListeObservable;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Tirs.Tir;
import model.Tirs.Tir2Base;
import model.Tirs.Tir2Zone;

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
                    Circle r = new Circle();

                    if(change.getAddedSubList().get(i) instanceof Tir2Base){
                        r.setRadius(2);
                        r.setFill(Color.RED);
                    }

                    else if(change.getAddedSubList().get(i) instanceof Tir2Zone) {
                        r.setRadius(4);
                        r.setFill(Color.PINK);
                    }

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
