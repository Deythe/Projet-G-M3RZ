package model;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import view.ViewTourelle;

public class Observateur implements ListChangeListener<Tourelles> {

    private Pane pane;

    public Observateur(Pane p){
        this.pane =p;
    }

    @Override
    public void onChanged(Change<? extends Tourelles> change) {
        while(change.next()){
            if(change.wasAdded()){
                for (int i = 0; i < change.getAddedSubList().size(); ++i) {
                    ViewTourelle.afficherTourelle(this.pane, change.getAddedSubList().get(i));
                }
            }
        }
    }
}
