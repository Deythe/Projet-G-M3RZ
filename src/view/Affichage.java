package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import model.BananaMan;
import model.Ennemies;
import model.Map;

public class Affichage {

    public static void affichermap(TilePane t, Map map){
        for(int x=0; x<map.getMap().length; x++){
            for(int y=0; y<map.getMap()[x].length;y++){
                Image image = new Image("/images/tilesetTest.png");
                ImageView test = new ImageView();
                test.setImage(image);
                switch (map.getMap()[x][y]){
                    case 0:
                        test.setViewport(new Rectangle2D(0,0,32,32));
                        break;
                    case 1:
                        test.setViewport(new Rectangle2D(32,0,32,32));
                        break;
                    case 2:
                        test.setViewport(new Rectangle2D(64,0,32,32));
                        break;
                    case 3:
                        test.setViewport(new Rectangle2D(96,0,32,32));
                        break;
                    case 4:
                        test.setViewport(new Rectangle2D(0,32,32,32));
                        break;
                    case 5:
                        test.setViewport(new Rectangle2D(32,32,32,32));
                        break;
                    case 6:
                        test.setViewport(new Rectangle2D(64,32,32,32));
                        break;
                    case 7:
                        test.setViewport(new Rectangle2D(96,32,32,32));
                        break;
                    case 8:
                        test.setViewport(new Rectangle2D(0,64,32,32));
                        break;
                    case 9:
                        test.setViewport(new Rectangle2D(32,64,32,32));
                        break;
                    default:break;
                }
                t.getChildren().add(test);
            }
        }
    }

    public static void afficherMob(Pane p, Ennemies a){
        ImageView test = new ImageView();
        if(a instanceof BananaMan){
            test.setImage(new Image("/images/Banana junky.png"));
        }
        test.setId(a.getId());
        p.getChildren().add(test);
    }
}
