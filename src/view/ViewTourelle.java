package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Tourelles.*;
import model.Tourelles.Tourelles;

public class ViewTourelle {

    private Pane p;

    public ViewTourelle(Pane p) {
        this.p = p;
    }
    public void afficherTourelle(Tourelles a) {
        ImageView test = new ImageView();
        if (a instanceof Tourelle2Base) {
            test.setImage(new Image("/images/Tourelle2Base.png"));
        }

        else if(a instanceof Tourelle2Slow) {
            test.setImage(new Image("/images/Tourelle2Slow.png"));
        }

        else if(a instanceof Tourelle2Zone) {
            test.setImage(new Image("/images/Tourelle2Zone.png"));
        }
        test.setId(a.getId());
        test.setTranslateX(a.getXValues());
        test.setTranslateY(a.getYValues());
        this.p.getChildren().add(test);
    }
}