package model.ListeObservable;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import model.Tourelles.Tourelles;
import view.ViewTourelle;

public class ObsListTourelle implements ListChangeListener<Tourelles> {
    //Liste qui observe comment réagi la liste des Tourelles du modèle


    private Pane pane;
    private ViewTourelle vT;

    public ObsListTourelle(Pane p, ViewTourelle t){
        this.pane =p;
        this.vT = t;
    }

    @Override
    public void onChanged(Change<? extends Tourelles> change) {
        while(change.next()){
            //Si une tourelle est ajouté, on crée son image
            if(change.wasAdded()){
                for (int i = 0; i < change.getAddedSubList().size(); ++i) {
                    this.vT.afficherTourelle(change.getAddedSubList().get(i));
                }
            }

            //Si une tourelle est retiré, on retire son image
            else if(change.wasRemoved()){
                for(int i = this.pane.getChildren().size() - 1; i >= 0; i--){
                    if(this.pane.getChildren().get(i).getId().equals(change.getRemoved().get(0).getId())){
                        this.pane.getChildren().remove(i);
                    }
                }
            }
        }
    }
}
