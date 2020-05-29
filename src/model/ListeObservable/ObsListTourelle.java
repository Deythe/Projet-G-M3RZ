package model.ListeObservable;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import model.Tourelles.Tourelles;
import view.ViewTourelle;

public class ObsListTourelle implements ListChangeListener<Tourelles> {

    private Pane pane;
    private ViewTourelle vT;

    public ObsListTourelle(Pane p, ViewTourelle t){
        this.pane =p;
        this.vT = t;
    }

    @Override
    public void onChanged(Change<? extends Tourelles> change) {
        while(change.next()){
            if(change.wasAdded()){
                for (int i = 0; i < change.getAddedSubList().size(); ++i) {
                    this.vT.afficherTourelle(change.getAddedSubList().get(i));
                }
            }
        }
    }
}
