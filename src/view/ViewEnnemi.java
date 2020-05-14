package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.BananaMan;
import model.Ennemies;

public class ViewEnnemi {
    public static void afficherMob(Pane p, Ennemies a){
        ImageView test = new ImageView();
        if(a instanceof BananaMan){
            test.setImage(new Image("/images/Banana junky.png"));
        }
        test.setId(a.getId());
        p.getChildren().add(test);
    }
}
