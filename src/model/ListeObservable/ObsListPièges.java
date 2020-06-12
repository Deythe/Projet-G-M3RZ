package model.ListeObservable;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import model.Pièges.Piege;
import view.ViewPiege;

public class ObsListPièges  implements ListChangeListener<Piege> {
    //Liste qui observe comment réagi la liste de pièges du modèle

    private Pane pane;
    private ViewPiege viewpiege;

    public ObsListPièges(Pane p, ViewPiege vP){
        this.pane =p;
        this.viewpiege= vP;
    }

    @Override
    public void onChanged(Change<? extends Piege> change) {
        while(change.next()) {
            //Si un piège est ajouté, on crée un sprite
            if(change.wasAdded()){
                for (int i = 0; i < change.getAddedSubList().size(); ++i) {
                    this.viewpiege.afficherPiege(change.getAddedSubList().get(i));
                }
            }

            //Si un piège est retiré, on le supprime
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


