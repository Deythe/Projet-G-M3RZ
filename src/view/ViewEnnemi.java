package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Ennemies.*;
import model.Ennemies.Ennemies;

public class ViewEnnemi {
    private Pane p;

    public ViewEnnemi(Pane p) {
        this.p = p;
    }

    public void afficherMob(Ennemies a){
        ImageView test = new ImageView();
        if(a instanceof BananaMan){
            test.setImage(new Image("/images/Banana junky.png"));
        }

        else if(a instanceof Plank){
            test.setImage(new Image("/images/Plank.png"));
        }

        else if(a instanceof Pepino){
            test.setImage(new Image("/images/Pepino.png"));
        }

        else if(a instanceof EnnemIEM){
            test.setImage(new Image("/images/Patatos.png"));
        }

        test.setId(a.getId());
        this.p.getChildren().add(test);
    }
}
