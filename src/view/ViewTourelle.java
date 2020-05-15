package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.BananaMan;
import model.Ennemies;
import model.Tourelle2Base;
import model.Tourelles;

public class ViewTourelle {
    public static void afficherTourelle(Pane p, Tourelles a) {
        ImageView test = new ImageView();
        if (a instanceof Tourelle2Base) {
            test.setImage(new Image("/images/Platform (1).png"));
        }
        test.setId(a.getId());
        test.setTranslateX(a.getXValues());
        test.setTranslateY(a.getYValues());
        p.getChildren().add(test);
    }
}
