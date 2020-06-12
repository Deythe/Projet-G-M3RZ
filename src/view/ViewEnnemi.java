package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Ennemies.*;
import model.Ennemies.Ennemis;

//C'est ici qu'on gère la création d'image des ennemie
public class ViewEnnemi {
    private Pane p;

    public ViewEnnemi(Pane p) {
        this.p = p;
    }

    public void afficherMob(Ennemis a){
        //On crée une image view et en fonction de la classe du mob il aura une image différente

        ImageView test = new ImageView();
        if(a instanceof Carambo){
            test.setImage(new Image("/images/Karambo.gif"));
        }

        else if(a instanceof Plank){
            test.setImage(new Image("/images/Plank.png"));
        }

        else if(a instanceof Pepino){
            test.setImage(new Image("/images/Pepino.png"));
        }

        else if(a instanceof Gladiem){
            test.setImage(new Image("/images/Patatos.png"));
        }

        test.setId(a.getId());
        this.p.getChildren().add(test);
    }
}
