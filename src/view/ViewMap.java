package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import model.Map;

public class ViewMap {

    private TilePane p;

    public ViewMap(TilePane p) {
        this.p = p;
    }

    public void affichermap(Map map){
        Image image = new Image("/images/tilesetTest.png");
        for(int x=0; x<map.getMap().length; x++){
            for(int y=0; y<map.getMap()[x].length;y++){
                ImageView test = new ImageView();
                test.setImage(image);
                switch (map.getMap()[x][y]){
                    case -1:
                        test.setViewport(new Rectangle2D(0,0,32,32));
                        break;
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
                    case 17:
                        test.setViewport(new Rectangle2D(32,128,32,32));
                        break;
                    case 20:
                        test.setViewport(new Rectangle2D(0,160,32,32));
                        break;
                    case 21:
                        test.setViewport(new Rectangle2D(32,160,32,32));
                        break;
                    case 22:
                        test.setViewport(new Rectangle2D(64,160,32,32));
                        break;
                    case 24:
                        test.setViewport(new Rectangle2D(0,192,32,32));
                        break;
                    case 25:
                        test.setViewport(new Rectangle2D(32,192,32,32));
                        break;
                    case 100:
                        test.setViewport(new Rectangle2D(0,0,32,32));
                        break;
                    default:break;
                }
                this.p.getChildren().add(test);
            }
        }
    }
}
