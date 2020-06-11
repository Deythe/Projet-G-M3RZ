package model.ListeObservable;

import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.Pièges.Piege;
import model.Pièges.Ressort;
import model.Tirs.Tir;
import model.Tirs.Tir2Base;
import model.Tirs.Tir2Zone;
import view.ViewPiege;

public class ObsListPièges  implements ListChangeListener<Piege> {

    private Pane pane;
    private ViewPiege viewpiege;

    public ObsListPièges(Pane p, ViewPiege vP){
        this.pane =p;
        this.viewpiege= vP;
    }

    @Override
    public void onChanged(Change<? extends Piege> change) {
        while(change.next()) {
            if(change.wasAdded()){
                for (int i = 0; i < change.getAddedSubList().size(); ++i) {
                    this.viewpiege.afficherPiege(change.getAddedSubList().get(i));
                }
            }
        }
    }
}


