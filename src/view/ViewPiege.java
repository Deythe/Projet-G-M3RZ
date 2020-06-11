package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Pièges.Mine;
import model.Pièges.Piege;
import model.Pièges.Ressort;
import model.Pièges.Trappe;

public class ViewPiege {

    private Pane p;

    public ViewPiege(Pane p) {
        this.p = p;
    }

    public void afficherPiege(Piege a) {
        ImageView test = new ImageView();
        if (a instanceof Ressort) {
            test.setImage(new Image("/images/Ressort.png"));
        } else if (a instanceof Mine) {
            test.setImage(new Image("/images/Mine.png"));
        } else if (a instanceof Trappe) {
            test.setImage(new Image("/images/Trappe.png"));
        }

        test.setId(a.getId());
        test.setTranslateX(a.getX());
        test.setTranslateY(a.getY());
        this.p.getChildren().add(test);
    }
}

